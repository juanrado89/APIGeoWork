package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.entities.ExperienciaTotal;

public interface ExperienciaTotalMapper {

    ExperienciaTotalDto toDto(ExperienciaTotal experienciaTotal);
    ExperienciaTotal toEntity(ExperienciaTotalDto experienciaTotalDto);
}
