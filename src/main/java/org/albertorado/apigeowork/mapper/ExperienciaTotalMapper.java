package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring", uses = {DescripcionExperienciaMapper.class})
public interface ExperienciaTotalMapper {

    @Mapping(source = "idExperienciaTotal", target = "idExperienciaTotal")
    @Mapping(source = "descripcionExperiencia", target = "descripcionExperiencia")

    ExperienciaTotalDto toDto(ExperienciaTotal experienciaTotal);
    ExperienciaTotal toEntity(ExperienciaTotalDto experienciaTotalDto);

}
