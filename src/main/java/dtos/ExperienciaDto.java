package dtos;

import java.sql.Timestamp;
import java.util.List;

public interface ExperienciaDto {

    int getIdExperiencia();

    NivelEducativoDto getNivelEducativo();

    List<SectorDto> getSector();

    ExperienciaTotalDto getExperienciaTotal();

    DocumentoDto getCvUrl();

    Timestamp getFecha_registro();

    int getEstado();
}
