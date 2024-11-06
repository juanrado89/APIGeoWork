package org.albertorado.apigeowork.dtos;

import java.sql.Timestamp;

public class NivelEducativoDto {

    private int idNivelEducativo;
    private String tituloNivelEducativo;
    private String centroEducativo;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private NivelDto nivel;

    public int getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(int idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    public String getTituloNivelEducativo() {
        return tituloNivelEducativo;
    }

    public void setTituloNivelEducativo(String tituloNivelEducativo) {
        this.tituloNivelEducativo = tituloNivelEducativo;
    }

    public String getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(String centroEducativo) {
        this.centroEducativo = centroEducativo;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public NivelDto getNivel() {
        return nivel;
    }

    public void setNivel(NivelDto nivel) {
        this.nivel = nivel;
    }
}
