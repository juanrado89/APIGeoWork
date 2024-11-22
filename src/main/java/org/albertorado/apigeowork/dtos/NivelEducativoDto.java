package org.albertorado.apigeowork.dtos;


public class NivelEducativoDto {

    private int idNivelEducativo;
    private String tituloNivelEducativo;
    private String centroEducativo;
    private String fechaInicio;
    private String fechaFin;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public NivelDto getNivel() {
        return nivel;
    }

    public void setNivel(NivelDto nivel) {
        this.nivel = nivel;
    }
}
