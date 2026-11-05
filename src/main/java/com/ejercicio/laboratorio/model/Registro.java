package com.ejercicio.laboratorio.model;

import java.time.LocalDateTime;

public class Registro {
    private Integer idUsuario;
    private String ruta;
    private String estacion;
    private Accion accion;
    private LocalDateTime fechaRegistro;

    public Registro(Integer idUsuario, String ruta, String estacion, Accion accion, LocalDateTime fechaRegistro) {
        this.idUsuario = idUsuario;
        this.ruta = ruta;
        this.estacion = estacion;
        this.accion = accion;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
