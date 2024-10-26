package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.DescripcionExperienciaDto;
import org.albertorado.apigeowork.entities.DescripcionExperiencia;

public interface DescripcionExperienciaMapper {

    DescripcionExperienciaDto toDto(DescripcionExperiencia descripcionExperiencia);
    DescripcionExperiencia toEntity(DescripcionExperienciaDto descripcionExperienciaDto);

}
