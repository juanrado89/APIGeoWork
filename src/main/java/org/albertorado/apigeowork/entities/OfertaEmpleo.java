package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
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
public class OfertaEmpleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta",nullable = false)
    private int idOferta;

    @ManyToOne()
    @JoinColumn(name = "id_oferta", referencedColumnName = "id_oferta", nullable = false, updatable = false)
    private Empresa idEmpresa;

    @Basic
    @Column(name = "titulo",nullable = false)
    private String titulo;

    @Basic
    @Column(name = "cantidad",nullable = false)
    private int cantidad;

    @Basic
    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @ManyToOne()
    @JoinColumn(name = "id_oferta_empleo", referencedColumnName = "id_oferta_empleo", nullable = false, updatable = false)
    private Sector sector;

    @Basic
    @Column(name = "requisitos",nullable = false)
    private String requisitos;

    @ManyToOne()
    @JoinColumn(name = "id_oferta_empleo", referencedColumnName = "id_oferta_empleo", nullable = true, updatable = false)
    private NivelEducativo nivelEducativo;

    @Basic
    @Column(name = "salario_min",nullable = false)
    private float salarioMin;

    @Basic
    @Column(name = "salario_max",nullable = false)
    private float salarioMax;

    @ManyToOne()
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false, updatable = false)
    private Direccion direccion;

    @Basic
    @Column(name = "fecha_publicacion",nullable = false)
    private Timestamp fechaPublicacion;

    @Basic
    @Column(name = "estado",nullable = false)
    private int estado;

    @OneToMany(mappedBy = "ofertaEmpleo", cascade = CascadeType.ALL)
    private List<HorarioEntrevista> horarios;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdOferta());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OfertaEmpleo oferta = (OfertaEmpleo) obj;
        return idOferta == oferta.idOferta;
    }

}
