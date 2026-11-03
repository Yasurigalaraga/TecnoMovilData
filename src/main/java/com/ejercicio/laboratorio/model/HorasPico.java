package com.ejercicio.laboratorio.model;

import java.time.LocalTime;

public class HorasPico {
    private LocalTime hora;
    private Integer cantidadRegistros;

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Integer getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void setCantidadRegistros(Integer cantidadRegistros) {
        this.cantidadRegistros = cantidadRegistros;
    }
}
