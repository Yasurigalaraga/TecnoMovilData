package com.ejercicio.laboratorio.controller;

import com.ejercicio.laboratorio.data.RegistrosPrueba;
import com.ejercicio.laboratorio.model.HorasPico;
import com.ejercicio.laboratorio.model.Registro;
import com.ejercicio.laboratorio.model.SobreCargaRuta;
import com.ejercicio.laboratorio.model.ViajePorUsuario;
import com.ejercicio.laboratorio.service.ReporteRegistros;
import com.ejercicio.laboratorio.service.impl.ReporteRegistrosImpl;
import com.ejercicio.laboratorio.view.TransporteView;

import java.util.List;
import java.util.Map;

public class ReporteRegistroController {

    private ReporteRegistros reporteRegistros;
    private TransporteView view;

    public ReporteRegistroController(ReporteRegistrosImpl reporteRegistrosImpl, TransporteView view) {
        this.reporteRegistros = reporteRegistrosImpl;
        this.view = view;
    }

    public void consultarAfluentesPorEstacion(){
        List<Registro> listaRegistros = RegistrosPrueba.obtenerRegistros();
        Map<String, Integer> afluentesPorEstacion = reporteRegistros.calculoAfluenciaPorEstacion(listaRegistros);
        view.reporteAfluentePorEstacion(afluentesPorEstacion);
    }

    public void consultarHoraPico(){
        List<Registro> listaRegistros = RegistrosPrueba.obtenerRegistros();
        List<HorasPico> horasPicos = reporteRegistros.calculoHoraPico(listaRegistros);
        view.reporteHoraPico(horasPicos);
    }

    public void consultarRuta(){
        List<Registro> listaRegistros = RegistrosPrueba.obtenerRegistros();
        List<String> Rutas = reporteRegistros.rutasMasUtilizadas(listaRegistros);
        view.reporteDeRuta(Rutas);
    }

    public void consultarEstacionesVisitadas(){
        List<Registro> listaRegistros = RegistrosPrueba.obtenerRegistros();
        List<ViajePorUsuario> listaDeViajesPorUsuaario =reporteRegistros.estacionesVisitadas(listaRegistros);
        view.reporteviajePorUsuario(listaDeViajesPorUsuaario);
    }

    public void consultarPromedioPorEstacion(){
        List<Registro> listaRegistros = RegistrosPrueba.obtenerRegistros();
        Map<String, Double> promedio = reporteRegistros.promedioEntreEstaciones(listaRegistros);
        view.reportePromedio(promedio);
    }

    public void consultarRutaSobrecarga(){
        List<Registro> listaRegistros = RegistrosPrueba.obtenerRegistros();
        List<SobreCargaRuta> sobreCargaRutas = reporteRegistros.rutasSobrecargadas(listaRegistros);
        view.reporteRutaSobrecarga(sobreCargaRutas);
    }
}
