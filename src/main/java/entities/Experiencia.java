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
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia",nullable = false)
    private int idExperiencia;

    @Basic
    @Column(name = "nivel_educativo",nullable = false)
    private String nivelEducativo;

    @Basic
    @Column(name = "experiencia_total",nullable = true)
    private int experienciaTotal;

    @Basic
    @Column(name = "resumen_profesional",nullable = true)
    private String resumenProfesional;

    @OneToOne(mappedBy = "id_documento")
    private Documento cvUrl;

    @Basic
    @Column(name = "fecha_registro",nullable = false)
    private Timestamp fecha_registro;

    @Basic
    @Column(name = "estado",nullable = false)
    private int estado;


    @Override
    public int hashCode() {
        return Objects.hashCode(getIdExperiencia());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Experiencia experiencia = (Experiencia) obj;
        return idExperiencia == experiencia.idExperiencia;
    }

}
