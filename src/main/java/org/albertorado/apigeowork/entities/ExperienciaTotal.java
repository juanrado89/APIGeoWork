package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;


import java.util.List;

@Entity

public class ExperienciaTotal {

    public ExperienciaTotal(int idExperienciaTotal, List<DescripcionExperiencia> descripcionExperiencia, Experiencia experiencia) {
        this.idExperienciaTotal = idExperienciaTotal;
        this.descripcionExperiencia = descripcionExperiencia;
        this.experiencia = experiencia;
    }

    public ExperienciaTotal() {
    }

    public int getIdExperienciaTotal() {
        return idExperienciaTotal;
    }

    public void setIdExperienciaTotal(int idExperienciaTotal) {
        this.idExperienciaTotal = idExperienciaTotal;
    }

    public List<DescripcionExperiencia> getDescripcionExperiencia() {
        return descripcionExperiencia;
    }

    public void setDescripcionExperiencia(List<DescripcionExperiencia> descripcionExperiencia) {
        this.descripcionExperiencia = descripcionExperiencia;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia_total",nullable = true)
    private int idExperienciaTotal;

    @OneToMany(mappedBy = "experienciaTotal", cascade = CascadeType.REMOVE)
    private List<DescripcionExperiencia> descripcionExperiencia;

    @OneToOne(mappedBy = "experienciaTotal")
    private Experiencia experiencia;


    @Basic
    @Column(name = "fecha_registro",nullable = false)
    private String fechaRegistro;
}
