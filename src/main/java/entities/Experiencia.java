package entities;

import jakarta.persistence.Entity;
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

    private int idExperiencia;
    private String nivelEducativo;
    private int experienciaTotal;
    private String resumenProfesional;
    private String cvUrl;
    private Timestamp fecha_registro;
    private int estado;

}
