package org.albertorado.apigeowork.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class OfertaEmpleoDto {


    private int idOferta;
    private EmpresaDto empresa;
    private String titulo;
    private int cantidad;
    private String descripcion;
    private SectorDto sector;
    private String requisitos;
    private NivelDto nivel;
    private float salarioMin;
    private float salarioMax;
    private DireccionDto direccion;
    private LocalDate fechaPublicacion;
    private boolean estado;
    private List<PerfilUsuarioDto> trabajadores;
    private List<HorarioEntrevistaDto> horarios;

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

    public NivelDto getNivel() {
        return nivel;
    }

    public void setNivel(NivelDto nivel) {
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

    public DireccionDto getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDto direccion) {
        this.direccion = direccion;
    }

    public String getFechaPublicacion() {
        if (this.fechaPublicacion != null) {
            return this.fechaPublicacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return null;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<PerfilUsuarioDto> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajador(List<PerfilUsuarioDto> trabajador) {
        this.trabajadores = trabajadores;
    }

    public boolean isEstado() {
        return estado;
    }

    public List<HorarioEntrevistaDto> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioEntrevistaDto> horarios) {
        this.horarios = horarios;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        try {
            this.fechaPublicacion = LocalDate.parse(fechaPublicacion, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("El formato de la fecha no es válido. Se espera 'dd/MM/yyyy'.");
        }
    }
}
