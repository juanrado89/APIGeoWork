package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.DatosDto;
import org.albertorado.apigeowork.entities.Datos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DatosMapper {
    DatosDto toDto(Datos datos);
    Datos toEntity(DatosDto dto);
}
