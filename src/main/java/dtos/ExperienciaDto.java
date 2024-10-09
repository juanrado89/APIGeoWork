package dtos;

import entities.Documento;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

import java.sql.Timestamp;

public interface ExperienciaDto {

    int getIdExperiencia();

    String getNivelEducativo();

    int getExperienciaTotal();

    String getResumenProfesional();

    DocumentoDto getCvUrl();

    Timestamp getFecha_registro();

    int getEstado();
}
