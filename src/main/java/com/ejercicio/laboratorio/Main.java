package com.ejercicio.laboratorio;

import com.ejercicio.laboratorio.controller.ReporteRegistroController;
import com.ejercicio.laboratorio.service.impl.ReporteRegistrosImpl;
import com.ejercicio.laboratorio.view.TransporteView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ReporteRegistroController controller = new ReporteRegistroController(new ReporteRegistrosImpl(), new TransporteView());
        controller.consultarAfluentesPorEstacion();
    }
}