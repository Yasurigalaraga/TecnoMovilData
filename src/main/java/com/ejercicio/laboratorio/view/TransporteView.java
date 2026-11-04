package com.ejercicio.laboratorio.view;

import java.util.Map;
import java.util.Scanner;

public class TransporteView {

    Scanner scan = new Scanner(System.in);

    public void reporteAfluentePorEstacion(Map<String, Integer> afluentesPorEstacion){
        afluentesPorEstacion.forEach((key, value) -> System.out.println(">> Estacion: " + key + " [" + value + "]."));
    }
}
