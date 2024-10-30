package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DescripcionExperiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descripcion_experiencia",nullable = false)
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

    @Basic
    @Column(name = "fecha_inicio",nullable = false)
    private Timestamp fechaInicio;

    @Basic
    @Column(name = "fecha_fin",nullable = false)
    private Timestamp fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_experiencia_total", referencedColumnName = "id_experiencia_total", nullable = false, updatable = false)
    private ExperienciaTotal experienciaTotal;
}
