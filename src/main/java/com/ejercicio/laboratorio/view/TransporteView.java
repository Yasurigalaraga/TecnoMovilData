package com.ejercicio.laboratorio.view;

import com.ejercicio.laboratorio.controller.ReporteRegistroController;
import com.ejercicio.laboratorio.model.HorasPico;
import com.ejercicio.laboratorio.model.SobreCargaRuta;
import com.ejercicio.laboratorio.model.ViajePorUsuario;
import com.ejercicio.laboratorio.service.impl.ReporteRegistrosImpl;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TransporteView {

    ReporteRegistroController controller;
    Scanner scan = new Scanner(System.in);

    public TransporteView() {
        this.controller = new ReporteRegistroController(new ReporteRegistrosImpl(), this);
    }

    public void menu(){
        boolean continuar = true;
        do{
            String menu = ">> MENU DE OPCIONES <<\n" +
                    "\t1. Consultar afluentes por estacion\n" +
                    "\t2. Consultar hora pico\n" +
                    "\t3. Consultar ruta\n" +
                    "\t4. Consultar estaciones visitadas\n" +
                    "\t5. Consultar promedio por estacion\n" +
                    "\t6. Consultar ruta sobrecargada\n" +
                    "\t7. Salir\n";

            String elegirOpcion = "Elige una opcion: ";


            System.out.println("\n" + menu);
            System.out.print(elegirOpcion);

            String opcion = scan.nextLine();

            switch (opcion){
                case "1":
                    controller.consultarAfluentesPorEstacion();
                    break;
                case "2":
                    controller.consultarHoraPico();
                    break;
                case "3":
                    controller.consultarRuta();
                    break;
                case "4":
                    controller.consultarEstacionesVisitadas();
                    break;
                case "5":
                    controller.consultarPromedioPorEstacion();
                    break;
                case "6":
                    controller.consultarRutaSobrecarga();
                    break;
                case "7":
                    System.out.println("\n>>     FIN DEL PROGRAMA     <<");;
                    continuar = false;
                    break;
                default:
                    System.out.println("[Error] - Opcion " + opcion + " no es valido.");
                    System.out.println("Elija una opcion valida.");
            }
            System.out.println("\n\n");
        }while (continuar);
    }

    public void reporteAfluentePorEstacion(Map<String, Integer> afluentesPorEstacion){
        System.out.println("\n\n## Consultar afluentes por estacion ##");
        afluentesPorEstacion.forEach((key, value) -> System.out.println(">> Estacion: " + key + " [" + value + "]."));
    }

    public void reporteHoraPico(List<HorasPico> listHorasPicos){
        System.out.println("\n\n## Consultar hora pico ##");
        listHorasPicos.forEach(horasPico -> System.out.println("Hora: " + horasPico.getHora() + " [" + horasPico.getCantidadRegistros() + "]."));
    }

    public void reporteDeRuta(List<String> rutas){
        System.out.println("\n\n## Consultar ruta ##");
        rutas.forEach(ruta-> System.out.println("Ruta: " + ruta));
    }

    public void reporteviajePorUsuario(List<ViajePorUsuario> viajePorUsuarios){
        System.out.println("\n\n## Consultar estaciones visitadas ##");
        viajePorUsuarios.forEach(viajePorUsuario -> {
            System.out.println(">> Viaje usuario: ");
            System.out.println("ID usuario: " + viajePorUsuario.getIdusuario());
            System.out.print("Viajes: " );
            System.out.print(viajePorUsuario.getEstaciones() + " - ");
            System.out.println();
            System.out.println();
        });

    }

    public void reportePromedio(Map<String, Double> promedioPorEstacion){
        System.out.println("\n\n## Consultar promedio por estacion ##");
        promedioPorEstacion.forEach((estaciones, promedio) -> System.out.println("Estacion: " + estaciones + " - Promedio: " + promedio));
    }

    public void reporteRutaSobrecarga(List<SobreCargaRuta> rutas){
        System.out.println("\n\n## Consultar ruta sobrecargada ##");
        rutas.forEach(sobreCargaRuta -> {
            System.out.println("Ruta: " + sobreCargaRuta.getRuta() + " - Cantidad: " + sobreCargaRuta.getCantidad());
        });

    }
}
