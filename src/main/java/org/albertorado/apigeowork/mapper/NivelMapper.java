package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.NivelDto;
import org.albertorado.apigeowork.entities.Nivel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NivelMapper {

    @Mapping(source = "idNivel", target = "idNivel")
    @Mapping(source = "nombreNivel", target = "nombreNivel")

    NivelDto toDto(Nivel nivel);
    Nivel toEntity(NivelDto nivelDto);

    List<NivelDto> toDto(List<Nivel> resultado);
}
