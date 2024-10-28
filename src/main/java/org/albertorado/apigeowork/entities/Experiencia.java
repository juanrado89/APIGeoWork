package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia",nullable = false)
    private int idExperiencia;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_experiencia", referencedColumnName = "id_experiencia", nullable = false, updatable = false)
    private NivelEducativo nivelEducativo;

    @NotNull
    @ManyToMany(mappedBy = "sectores")
    private List<Sector> sector;

    @OneToOne(mappedBy = "experienciaTotal")
    private ExperienciaTotal experienciaTotal;

    @OneToOne(mappedBy = "id_documento")
    private Documento cvUrl;

    @NotNull
    @Basic
    @Column(name = "fecha_registro",nullable = false)
    private Timestamp fecha_registro;

    @NotNull
    @Digits(integer = 1,fraction = 0)
    @Basic
    @Column(name = "estado",precision = 1,nullable = false)
    private int estado;


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
