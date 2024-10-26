package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.NivelEducativoDto;
import org.albertorado.apigeowork.entities.NivelEducativo;

public interface NivelEducativoMapper {

    NivelEducativoDto toDto(NivelEducativo nivelEducativo);
    NivelEducativo toEntity(NivelEducativoDto nivelEducativoDto);
}
