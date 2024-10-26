package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
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
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel",nullable = false)
    private int idNivel;

    @Basic
    @Column(name = "nombre_nivel",nullable = false)
    private String nombreNivel;

    @OneToMany(mappedBy = "nivel")
    private List<NivelEducativo> nivelesEducativos;
}
