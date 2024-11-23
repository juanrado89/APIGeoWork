package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;

@Entity

public class ExperienciaTotal {

    public ExperienciaTotal(int idExperienciaTotal) {
        this.idExperienciaTotal = idExperienciaTotal;
    }

    public ExperienciaTotal() {
    }

    public int getIdExperienciaTotal() {
        return idExperienciaTotal;
    }

    public void setIdExperienciaTotal(int idExperienciaTotal) {
        this.idExperienciaTotal = idExperienciaTotal;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia_total",nullable = true)
    private int idExperienciaTotal;

    @OneToMany(mappedBy = "experienciaTotal", cascade = CascadeType.ALL)
    private List<DescripcionExperiencia> descripcionExperiencia;

    @OneToOne(mappedBy = "experienciaTotal")
    private Experiencia experiencia;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdExperienciaTotal());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ExperienciaTotal experiencia = (ExperienciaTotal) obj;
        return idExperienciaTotal == experiencia.idExperienciaTotal;
    }
}
