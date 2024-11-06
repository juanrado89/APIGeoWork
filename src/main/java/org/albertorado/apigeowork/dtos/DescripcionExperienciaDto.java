package org.albertorado.apigeowork.dtos;

import java.sql.Timestamp;

public class DescripcionExperienciaDto {

    private int idDescripcionExperiencia;
    private String nombreEmpresa;
    private String descripcion;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;

    public int getIdDescripcionExperiencia() {
        return idDescripcionExperiencia;
    }

    public void setIdDescripcionExperiencia(int idDescripcionExperiencia) {
        this.idDescripcionExperiencia = idDescripcionExperiencia;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
