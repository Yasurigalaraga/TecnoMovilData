package com.ejercicio.laboratorio.controller;

import com.ejercicio.laboratorio.data.RegistrosPrueba;
import com.ejercicio.laboratorio.model.Registro;
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
}
