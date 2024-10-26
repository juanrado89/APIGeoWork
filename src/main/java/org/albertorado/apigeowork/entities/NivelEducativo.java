package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NivelEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_educativo",nullable = false)
    private int idNivelEducativo;

    @Basic
    @Column(name = "titulo_nivel_educativo",nullable = false)
    private String tituloNivelEducativo;

    @Basic
    @Column(name = "fecha_inicio",nullable = false)
    private Timestamp fechaInicio;

    @Basic
    @Column(name = "fecha_fin",nullable = false)
    private Timestamp fechaFin;

    @ManyToOne()
    @JoinColumn(name = "id_nivel_educativo", referencedColumnName = "id_nivel_educativo", nullable = true, updatable = false)
    private Nivel nivel;

    @OneToMany(mappedBy = "nivelEducativo")
    private List<Experiencia> experiencias;

    @OneToMany(mappedBy = "nivelEducativo")
    private List<OfertaEmpleo> ofertas;
}
