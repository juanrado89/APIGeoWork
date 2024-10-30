package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.DescripcionExperienciaDto;
import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.entities.DescripcionExperiencia;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DescripcionExperienciaMapper {


    @Mapping(source = "idDescripcionExperiencia", target = "idDescripcionExperiencia")
    @Mapping(source = "nombreEmpresa", target = "nombreEmpresa")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "fechaInicio", target = "fechaInicio")
    @Mapping(source = "fechaFin", target = "fechaFin")

    DescripcionExperienciaDto toDto(DescripcionExperiencia descripcionExperiencia);
    DescripcionExperiencia toEntity(DescripcionExperienciaDto descripcionExperienciaDto);

}
