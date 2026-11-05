package com.ejercicio.laboratorio.service.impl;

import com.ejercicio.laboratorio.model.*;
import com.ejercicio.laboratorio.service.ReporteRegistros;

import java.time.Duration;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReporteRegistrosImpl implements ReporteRegistros {
    @Override
    public Map<String, Integer> calculoAfluenciaPorEstacion(List<Registro> listaRegistros) {
        return listaRegistros.stream()
                .collect(
                        Collectors.groupingBy(
                                Registro::getEstacion,
                                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }

    @Override
    public List<HorasPico> calculoHoraPico(List<Registro> listaRegistros) {
        return listaRegistros.stream()
                .collect(Collectors.groupingBy(registro -> registro.getFechaRegistro().getHour(), Collectors.counting()))
                .entrySet().stream()
                .map(entry -> new HorasPico(entry.getKey(), entry.getValue().intValue()))
                .sorted(Comparator.comparing(HorasPico::getCantidadRegistros).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> rutasMasUtilizadas(List<Registro> listaRegistros) {
        return listaRegistros.stream()
                .collect(Collectors.groupingBy(Registro::getRuta, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<ViajePorUsuario> estacionesVisitadas(List<Registro> listaRegistros) {
        return listaRegistros.stream()
                .sorted(Comparator.comparing(Registro::getFechaRegistro))
                .collect(Collectors.groupingBy(
                        Registro::getIdUsuario,
                        Collectors.mapping(
                                Registro::getEstacion,
                                Collectors.toList()
                        )
                ))
                .entrySet()
                .stream()
                .map(entry -> new ViajePorUsuario(
                        entry.getKey(),
                        entry.getValue()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Double> promedioEntreEstaciones(List<Registro> listaRegistros) {
        return listaRegistros.stream()
                .collect(Collectors.groupingBy(Registro::getIdUsuario))
                .values()
                .stream()
                .flatMap(registrosUsuario -> {

                    List<Registro> ordenados = registrosUsuario.stream()
                            .sorted(Comparator.comparing(Registro::getFechaRegistro))
                            .collect(Collectors.toList());

                    return IntStream.range(0, ordenados.size() - 1)
                            .mapToObj(i -> {
                                Registro actual = ordenados.get(i);
                                Registro siguiente = ordenados.get(i + 1);

                                long minutos = Duration.between(
                                        actual.getFechaRegistro(),
                                        siguiente.getFechaRegistro()
                                ).toMinutes();

                                return new TiempoEntreEstaciones(
                                        actual.getIdUsuario(),
                                        actual.getEstacion(),
                                        siguiente.getEstacion(),
                                        minutos
                                );
                            });
                })
                .filter(t -> !t.getEstacionOrigen().equals(t.getEstacionDestino()))
                .collect(Collectors.groupingBy(t -> t.getEstacionOrigen() + " - " + t.getEstacionDestino(),
                        Collectors.averagingLong(TiempoEntreEstaciones::getTiempoMinutos)
                ));
    }

    @Override
    public List<SobreCargaRuta> rutasSobrecargadas(List<Registro> listaRegistros) {
        return listaRegistros.stream()
                .collect(Collectors.groupingBy(Registro::getRuta, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .filter(entry -> entry.getValue() >= 50)
                .map(entry -> new SobreCargaRuta(entry.getKey(), entry.getValue().intValue()))
                .collect(Collectors.toList());
    }
}
