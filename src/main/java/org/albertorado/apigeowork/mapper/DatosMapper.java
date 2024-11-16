package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.DatosDto;
import org.albertorado.apigeowork.entities.Datos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DireccionMapper.class})
public interface DatosMapper {

    @Mapping(source = "idDatos", target = "idDatos")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellidos", target = "apellidos")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "fechaEdad", target = "fechaEdad")
    @Mapping(source = "direccion", target = "direccion")

    DatosDto toDto(Datos datos);
    Datos toEntity(DatosDto dto);
}
