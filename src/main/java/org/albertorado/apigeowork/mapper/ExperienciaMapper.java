package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.ExperienciaDto;
import org.albertorado.apigeowork.entities.Experiencia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienciaMapper {
    ExperienciaDto toDto(Experiencia experiencia);
    Experiencia toEntity(ExperienciaDto experienciaDto);
}
