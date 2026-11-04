package com.ejercicio.laboratorio.service.impl;

import com.ejercicio.laboratorio.model.HorasPico;
import com.ejercicio.laboratorio.model.Registro;
import com.ejercicio.laboratorio.model.SobreCargaRuta;
import com.ejercicio.laboratorio.model.ViajePorUsuario;
import com.ejercicio.laboratorio.service.ReporteRegistros;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        return List.of();
    }

    @Override
    public List<String> rutasMasUtilizadas(List<Registro> listaRegistros) {
        return List.of();
    }

    @Override
    public List<ViajePorUsuario> estacionesVisitadas(List<Registro> listaRegistros) {
        return List.of();
    }

    @Override
    public Double promedioEntreEstaciones(List<Registro> listaRegistros) {
        return 0.0;
    }

    @Override
    public List<SobreCargaRuta> rutasSobrecargadas(List<Registro> listaRegistros) {
        return List.of();
    }
}
