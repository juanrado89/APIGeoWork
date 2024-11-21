package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.sql.Timestamp;

@Entity

public class DescripcionExperiencia {
    public DescripcionExperiencia(int idDescripcionExperiencia, String nombreEmpresa, String descripcion,
                                  String fechaInicio, String fechaFin, ExperienciaTotal experienciaTotal) {
        this.idDescripcionExperiencia = idDescripcionExperiencia;
        this.nombreEmpresa = nombreEmpresa;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.experienciaTotal = experienciaTotal;
    }

    public DescripcionExperiencia() {
    }

    public int getIdDescripcionExperiencia() {
        return idDescripcionExperiencia;
    }

    public void setIdDescripcionExperiencia(int idDescripcionExperiencia) {
        this.idDescripcionExperiencia = idDescripcionExperiencia;
    }

    public @NotNull @Size(min = 0, max = 255) String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(@NotNull @Size(min = 0, max = 255) String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public @NotNull @Size(min = 0, max = 3000) String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotNull @Size(min = 0, max = 3000) String descripcion) {
        this.descripcion = descripcion;
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

    public ExperienciaTotal getExperienciaTotal() {
        return experienciaTotal;
    }

    public void setExperienciaTotal(ExperienciaTotal experienciaTotal) {
        this.experienciaTotal = experienciaTotal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descripcion_experiencia",nullable = true)
    private int idDescripcionExperiencia;

    @NotNull
    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "nombre_empresa",length = 255,nullable = false)
    private String nombreEmpresa;

    @NotNull
    @Size(min = 0,max = 3000)
    @Basic
    @Column(name = "descripcion",length = 3000,nullable = false)
    private String descripcion;

    @NotNull
    @Basic
    @Column(name = "fecha_inicio",nullable = false)
    private String fechaInicio;


    @Basic
    @Column(name = "fecha_fin",nullable = false)
    private String fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_experiencia_total", referencedColumnName = "id_experiencia_total", nullable = true, updatable = false)
    private ExperienciaTotal experienciaTotal;
}
