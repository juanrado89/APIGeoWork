package entities;

import jakarta.persistence.*;
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

    @Basic
    @Column(name = "nombre_empresa",nullable = false)
    private String nombreEmpresa;

    @Basic
    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Basic
    @Column(name = "fecha_inicio",nullable = false)
    private Timestamp fechaInicio;

    @Basic
    @Column(name = "fecha_fin",nullable = false)
    private Timestamp fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_descripcion_experiencia", referencedColumnName = "id_descripcion_experiencia", nullable = false, updatable = false)
    private ExperienciaTotal experienciaTotal;
}
