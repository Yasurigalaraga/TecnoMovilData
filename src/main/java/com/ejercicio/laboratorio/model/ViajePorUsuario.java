package com.ejercicio.laboratorio.model;

import java.util.List;

public class ViajePorUsuario {
    private Integer idusuario;
    private List<String> estaciones;

    public ViajePorUsuario(Integer idusuario, List<String> estaciones) {
        this.idusuario = idusuario;
        this.estaciones = estaciones;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public List<String> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(List<String> estaciones) {
        this.estaciones = estaciones;
    }
}
