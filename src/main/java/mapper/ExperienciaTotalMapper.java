package mapper;

import dtos.ExperienciaTotalDto;
import entities.ExperienciaTotal;

public interface ExperienciaTotalMapper {

    ExperienciaTotalDto toDto(ExperienciaTotal experienciaTotal);
    ExperienciaTotal toEntity(ExperienciaTotalDto experienciaTotalDto);
}
