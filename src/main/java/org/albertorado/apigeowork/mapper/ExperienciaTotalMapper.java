package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ExperienciaTotalMapper {

    @Mapping(source = "idExperienciaTotal", target = "idExperienciaTotal")

    ExperienciaTotalDto toDto(ExperienciaTotal experienciaTotal);
    ExperienciaTotal toEntity(ExperienciaTotalDto experienciaTotalDto);

}
