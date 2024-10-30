package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.NivelEducativoDto;
import org.albertorado.apigeowork.entities.NivelEducativo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {NivelMapper.class})
public interface NivelEducativoMapper {

    @Mapping(source = "idNivelEducativo", target = "idNivelEducativo")
    @Mapping(source = "tituloNivelEducativo", target = "tituloNivelEducativo")
    @Mapping(source = "fechaInicio", target = "fechaInicio")
    @Mapping(source = "fechaFin", target = "fechaFin")
    @Mapping(source = "nivel", target = "nivel")

    NivelEducativoDto toDto(NivelEducativo nivelEducativo);
    NivelEducativo toEntity(NivelEducativoDto nivelEducativoDto);
}
