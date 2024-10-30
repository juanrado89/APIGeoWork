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
    @JoinColumn(name = "id_nivel_educativo", referencedColumnName = "id_nivel_educativo", nullable = false, updatable = false)
    private NivelEducativo nivelEducativo;

    @NotNull
    @ManyToMany
    @JoinTable(name = "experiencia_sector", joinColumns = @JoinColumn(name = "id_experiencia"), inverseJoinColumns = @JoinColumn(name = "id_sector"))
    private List<Sector> sector;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_experiencia_total", referencedColumnName = "id_experiencia_total")
    private ExperienciaTotal experienciaTotal;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_documento", referencedColumnName = "id_documento")
    private Documento cvUrl;

    @NotNull
    @Basic
    @Column(name = "fecha_registro",nullable = false)
    private Timestamp fechaRegistro;

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
