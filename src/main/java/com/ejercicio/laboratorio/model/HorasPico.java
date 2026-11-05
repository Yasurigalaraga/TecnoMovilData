package com.ejercicio.laboratorio.model;

import java.time.LocalTime;

public class HorasPico {
    private Integer hora;
    private Integer cantidadRegistros;

    public HorasPico(Integer hora, Integer cantidadRegistros) {
        this.hora = hora;
        this.cantidadRegistros = cantidadRegistros;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Integer getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void setCantidadRegistros(Integer cantidadRegistros) {
        this.cantidadRegistros = cantidadRegistros;
    }
}
