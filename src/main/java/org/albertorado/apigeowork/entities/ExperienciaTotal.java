package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExperienciaTotal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia_total",nullable = true)
    private int idExperienciaTotal;

    @OneToMany(mappedBy = "experienciaTotal", cascade = CascadeType.REMOVE)
    private List<DescripcionExperiencia> descripcionExperiencia;

    @OneToOne(mappedBy = "experienciaTotal")
    private Experiencia experiencia;
}
