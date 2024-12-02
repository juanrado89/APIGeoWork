package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
public class NivelEducativo {

    public NivelEducativo(int idNivelEducativo, String tituloNivelEducativo, String centroEducativo,
                          String fechaInicio, String fechaFin, Nivel nivel, List<Experiencia> experiencias) {
        this.idNivelEducativo = idNivelEducativo;
        this.tituloNivelEducativo = tituloNivelEducativo;
        this.centroEducativo = centroEducativo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nivel = nivel;
        this.experiencias = experiencias;
    }

    public NivelEducativo() {
    }

    public int getIdNivelEducativo() {
        return idNivelEducativo;
    }

    public void setIdNivelEducativo(int idNivelEducativo) {
        this.idNivelEducativo = idNivelEducativo;
    }

    public @NotNull @Size(min = 0, max = 255) String getTituloNivelEducativo() {
        return tituloNivelEducativo;
    }

    public void setTituloNivelEducativo(@NotNull @Size(min = 0, max = 255) String tituloNivelEducativo) {
        this.tituloNivelEducativo = tituloNivelEducativo;
    }

    public @NotNull @Size(min = 0, max = 255) String getCentroEducativo() {
        return centroEducativo;
    }

    public void setCentroEducativo(@NotNull @Size(min = 0, max = 255) String centroEducativo) {
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

    public @NotNull Nivel getNivel() {
        return nivel;
    }

    public void setNivel(@NotNull Nivel nivel) {
        this.nivel = nivel;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_educativo",nullable = false)
    private int idNivelEducativo;

    @NotNull
    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "titulo_nivel_educativo",length = 255,nullable = false)
    private String tituloNivelEducativo;

    @NotNull
    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "centro_educativo",length = 255,nullable = false)
    private String centroEducativo;

    @Basic
    @Column(name = "fecha_inicio",nullable = false)
    private String fechaInicio;

    @Basic
    @Column(name = "fecha_fin",nullable = false)
    private String fechaFin;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel", nullable = true, updatable = false)
    private Nivel nivel;

    @OneToMany(mappedBy = "nivelEducativo")
    private List<Experiencia> experiencias;


    @Override
    public int hashCode() {
        return Objects.hashCode(getIdNivelEducativo());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NivelEducativo nivel = (NivelEducativo) obj;
        return idNivelEducativo == nivel.idNivelEducativo;
    }
}
