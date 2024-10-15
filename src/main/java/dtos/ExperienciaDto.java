package dtos;

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
