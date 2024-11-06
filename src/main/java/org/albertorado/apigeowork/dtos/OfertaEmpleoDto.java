package org.albertorado.apigeowork.dtos;

import java.sql.Timestamp;

public class OfertaEmpleoDto {

    private int idOferta;
    private EmpresaDto empresa;
    private String titulo;
    private int cantidad;
    private String descripcion;
    private SectorDto sector;
    private String requisitos;
    private NivelEducativoDto nivelEducativo;
    private float salarioMin;
    private float salarioMax;
    private DireccionDto direccion;
    private Timestamp fechaPublicacion;
    private int estado;

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public EmpresaDto getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDto empresa) {
        this.empresa = empresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public SectorDto getSector() {
        return sector;
    }

    public void setSector(SectorDto sector) {
        this.sector = sector;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public NivelEducativoDto getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(NivelEducativoDto nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
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

    public DireccionDto getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDto direccion) {
        this.direccion = direccion;
    }

    public Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
