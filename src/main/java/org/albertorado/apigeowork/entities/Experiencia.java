package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Experiencia {

    public Experiencia(int idExperiencia, NivelEducativo nivelEducativo, List<Sector> sector, ExperienciaTotal experienciaTotal, Documento cvUrl, String fechaRegistro, Trabajador trabajador) {
        this.idExperiencia = idExperiencia;
        this.nivelEducativo = nivelEducativo;
        this.sector = sector;
        this.experienciaTotal = experienciaTotal;
        this.cvUrl = cvUrl;
        this.fechaRegistro = fechaRegistro;
        this.trabajador = trabajador;
    }

    public Experiencia() {
    }

    public int getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public @NotNull NivelEducativo getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(@NotNull NivelEducativo nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public @NotNull List<Sector> getSector() {
        return sector;
    }

    public void setSector(@NotNull List<Sector> sector) {
        this.sector = sector;
    }

    public ExperienciaTotal getExperienciaTotal() {
        return experienciaTotal;
    }

    public void setExperienciaTotal(ExperienciaTotal experienciaTotal) {
        this.experienciaTotal = experienciaTotal;
    }

    public Documento getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(Documento cvUrl) {
        this.cvUrl = cvUrl;
    }

    public @NotNull String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(@NotNull String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia",nullable = false)
    private int idExperiencia;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_nivel_educativo", referencedColumnName = "id_nivel_educativo", nullable = false, updatable = false)
    private NivelEducativo nivelEducativo;

    @NotNull
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "experiencia_sector",
            joinColumns = @JoinColumn(name = "id_experiencia"),
            inverseJoinColumns = @JoinColumn(name = "id_sector"))
    private List<Sector> sector;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_experiencia_total", referencedColumnName = "id_experiencia_total")
    private ExperienciaTotal experienciaTotal;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_documento", referencedColumnName = "id_documento")
    private Documento cvUrl;

    @NotNull
    @Basic
    @Column(name = "fecha_registro",length = 3000,nullable = false)
    private String fechaRegistro;

    @OneToOne(mappedBy = "datosExperiencia")
    private Trabajador trabajador;


    @Override
    public int hashCode() {
        return Objects.hashCode(getIdExperiencia());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Experiencia experiencia = (Experiencia) obj;
        return idExperiencia == experiencia.idExperiencia;
    }

}
