package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
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

    @Basic
    @Column(name = "requisitos",nullable = false)
    private String requisitos;

    @Basic
    @Column(name = "nivel_educativo_requerido",nullable = false)
    private String nivelEducativoRequerido;

    @Basic
    @Column(name = "salario_min",nullable = false)
    private float salarioMin;

    @Basic
    @Column(name = "salario_max",nullable = false)
    private float salarioMax;

    @Basic
    @Column(name = "ciudad",nullable = false)
    private String ciudad;

    @ManyToOne()
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", nullable = false, updatable = false)
    private Pais pais;

    @Basic
    @Column(name = "fecha_publicacion",nullable = false)
    private Timestamp fechaPublicacion;

    @Basic
    @Column(name = "estado",nullable = false)
    private int estado;

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
