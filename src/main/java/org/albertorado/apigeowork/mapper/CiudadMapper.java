package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.CiudadDto;
import org.albertorado.apigeowork.entities.Ciudad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EstadoMapper.class})
public interface CiudadMapper {

    @Mapping(source = "idCiudad", target = "idCiudad")
    @Mapping(source = "ciudad", target = "ciudad")
    @Mapping(source = "estado", target = "estado")

    CiudadDto toDto(Ciudad ciudad);
    Ciudad toEntity(CiudadDto ciudadDto);

    List<CiudadDto> toDto(List<Ciudad> resultado);
}
