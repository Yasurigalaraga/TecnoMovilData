package com.ejercicio.laboratorio.model;

public class TiempoEntreEstaciones {
    private Integer idUsuario;
    private String estacionOrigen;
    private String estacionDestino;
    private Long tiempoMinutos;

    public TiempoEntreEstaciones(Integer idUsuario,
                                    String estacionOrigen,
                                    String estacionDestino,
                                    Long tiempoMinutos) {
        this.idUsuario = idUsuario;
        this.estacionOrigen = estacionOrigen;
        this.estacionDestino = estacionDestino;
        this.tiempoMinutos = tiempoMinutos;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getTiempoMinutos() {
        return tiempoMinutos;
    }

    public void setTiempoMinutos(Long tiempoMinutos) {
        this.tiempoMinutos = tiempoMinutos;
    }

    public String getEstacionDestino() {
        return estacionDestino;
    }

    public void setEstacionDestino(String estacionDestino) {
        this.estacionDestino = estacionDestino;
    }

    public String getEstacionOrigen() {
        return estacionOrigen;
    }

    public void setEstacionOrigen(String estacionOrigen) {
        this.estacionOrigen = estacionOrigen;
    }
}
