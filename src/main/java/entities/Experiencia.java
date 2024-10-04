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
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia",nullable = false)
    private int idExperiencia;

    @Basic
    @Column(name = "nivel_educativo",nullable = false)
    private String nivelEducativo;

    @Basic
    @Column(name = "experiencia_total",nullable = false)
    private int experienciaTotal;

    @Basic
    @Column(name = "resumen_profesional",nullable = false)
    private String resumenProfesional;


    private Documento cvUrl;

    @Basic
    @Column(name = "fecha_registro",nullable = false)
    private Timestamp fecha_registro;

    @Basic
    @Column(name = "estado",nullable = false)
    private int estado;

    @OneToOne(mappedBy = "idExperiencia")
    private Trabajador trabajador;

}
