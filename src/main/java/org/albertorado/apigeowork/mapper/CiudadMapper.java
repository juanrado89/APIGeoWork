package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.CiudadDto;
import org.albertorado.apigeowork.entities.Ciudad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EstadoMapper.class})
public interface CiudadMapper {

    @Mapping(source = "idCiudad", target = "idCiudad")
    @Mapping(source = "ciudad", target = "ciudad")
    @Mapping(source = "estado", target = "estado")

    CiudadDto toDto(Ciudad ciudad);
    Ciudad toEntity(CiudadDto ciudadDto);
}
