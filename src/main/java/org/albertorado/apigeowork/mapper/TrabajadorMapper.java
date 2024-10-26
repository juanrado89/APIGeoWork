package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.TrabajadorDto;
import org.albertorado.apigeowork.entities.Trabajador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrabajadorMapper {

    TrabajadorDto toDto(Trabajador trabajador);
    Trabajador toEntity(TrabajadorDto trabajadorDto);
}
