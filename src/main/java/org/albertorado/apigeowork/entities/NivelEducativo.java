package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private Timestamp fechaInicio;

    @Basic
    @Column(name = "fecha_fin",nullable = false)
    private Timestamp fechaFin;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel", nullable = true, updatable = false)
    private Nivel nivel;

    @OneToMany(mappedBy = "nivelEducativo")
    private List<Experiencia> experiencias;

    @OneToMany(mappedBy = "nivelEducativo")
    private List<OfertaEmpleo> ofertas;
}
