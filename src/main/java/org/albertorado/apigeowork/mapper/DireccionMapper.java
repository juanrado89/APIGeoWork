package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.DireccionDto;
import org.albertorado.apigeowork.entities.Direccion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DireccionMapper {
    DireccionDto toDto(Direccion direccion);
    Direccion toEntity(DireccionDto direccionDto);
}
