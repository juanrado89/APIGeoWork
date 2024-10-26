package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.DatosEmpresaDto;
import org.albertorado.apigeowork.entities.DatosEmpresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DatosEmpresaMapper {
    DatosEmpresaDto toDto(DatosEmpresa entity);
    DatosEmpresa toEntity(DatosEmpresaDto dto);
}
