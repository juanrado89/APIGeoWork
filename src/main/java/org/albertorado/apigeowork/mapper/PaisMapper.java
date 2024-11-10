package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.PaisDto;
import org.albertorado.apigeowork.entities.Pais;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaisMapper {

    @Mapping(source = "idPais", target = "idPais")
    @Mapping(source = "pais", target = "pais")

    PaisDto toDto(Pais pais);
    Pais toEntity(PaisDto paisDto);

    List<PaisDto> toDto(List<Pais> resultado);
}
