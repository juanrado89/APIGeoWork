package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.DireccionDto;
import org.albertorado.apigeowork.entities.Direccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DireccionMapper {

    @Mapping(source = "idDireccion", target = "idDireccion")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "piso", target = "piso")
    @Mapping(source = "puerta", target = "puerta")
    @Mapping(source = "codigoPostal", target = "codigoPostal")
    @Mapping(source = "ciudad", target = "ciudadIdDto")

    DireccionDto toDto(Direccion direccion);
    Direccion toEntity(DireccionDto direccionDto);
}
