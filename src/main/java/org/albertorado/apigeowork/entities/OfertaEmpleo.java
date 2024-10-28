package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_oferta", referencedColumnName = "id_oferta", nullable = false, updatable = false)
    private Empresa idEmpresa;

    @Basic
    @Size(min = 0,max = 255)
    @Column(name = "titulo",length = 255,nullable = false)
    private String titulo;

    @Basic
    @Digits(integer = 3,fraction = 0)
    @Column(name = "cantidad",precision = 3,nullable = false)
    private int cantidad;

    @NotNull
    @Size(min = 0,max = 3000)
    @Basic
    @Column(name = "descripcion",length = 3000,nullable = false)
    private String descripcion;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_oferta_empleo", referencedColumnName = "id_oferta_empleo", nullable = false, updatable = false)
    private Sector sector;

    @Size(min = 0,max = 3000)
    @Basic
    @Column(name = "requisitos",length = 3000,nullable = false)
    private String requisitos;

    @ManyToOne()
    @JoinColumn(name = "id_oferta_empleo", referencedColumnName = "id_oferta_empleo", nullable = true, updatable = false)
    private NivelEducativo nivelEducativo;

    @Basic
    @Digits(integer = 6, fraction = 2)
    @Column(name = "salario_min",precision = 8,scale = 2,nullable = false)
    private float salarioMin;

    @Basic
    @Digits(integer = 6, fraction = 2)
    @Column(name = "salario_max",precision = 8,scale = 2,nullable = false)
    private float salarioMax;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false, updatable = false)
    private Direccion direccion;

    @NotNull
    @Basic
    @Column(name = "fecha_publicacion",nullable = false)
    private Timestamp fechaPublicacion;

    @Basic
    @NotNull
    @Digits(integer = 1,fraction = 0)
    @Column(name = "estado",precision = 1,nullable = false)
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
