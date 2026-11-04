package com.ejercicio.laboratorio.service;

import com.ejercicio.laboratorio.model.HorasPico;
import com.ejercicio.laboratorio.model.Registro;
import com.ejercicio.laboratorio.model.SobreCargaRuta;
import com.ejercicio.laboratorio.model.ViajePorUsuario;

import java.util.List;
import java.util.Map;

public interface ReporteRegistros {
    Map<String, Integer> calculoAfluenciaPorEstacion(List<Registro> listaRegistros);
    List<HorasPico> calculoHoraPico(List<Registro> listaRegistros);
    List<String> rutasMasUtilizadas(List<Registro> listaRegistros);
    List<ViajePorUsuario> estacionesVisitadas(List<Registro> listaRegistros);
    Double promedioEntreEstaciones(List<Registro> listaRegistros);
    List<SobreCargaRuta> rutasSobrecargadas(List<Registro> listaRegistros);
}
