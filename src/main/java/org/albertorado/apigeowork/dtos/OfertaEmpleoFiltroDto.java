package org.albertorado.apigeowork.dtos;

public class OfertaEmpleoFiltroDto {
    private String pais;
    private String ciudad;
    private String sector;
    private String estado;
    private String titulo;
    private String requisitos;
    private String nivel;
    private float salarioMin;
    private float salarioMax;
    private Boolean estatus;
    private Boolean ordenarAscendente;

    // Getters y Setters

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public float getSalarioMin() {
        return salarioMin;
    }

    public void setSalarioMin(float salarioMin) {
        this.salarioMin = salarioMin;
    }

    public float getSalarioMax() {
        return salarioMax;
    }

    public void setSalarioMax(float salarioMax) {
        this.salarioMax = salarioMax;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public Boolean getOrdenarAscendente() {
        return ordenarAscendente;
    }

    public void setOrdenarAscendente(Boolean ordenarAscendente) {
        this.ordenarAscendente = ordenarAscendente;
    }
}

