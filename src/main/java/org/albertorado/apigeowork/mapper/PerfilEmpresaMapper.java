package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.PerfilEmpresaDto;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PerfilEmpresaMapper {
    PerfilEmpresaDto toDto(PerfilEmpresa perfilEmpresa);
    PerfilEmpresa toEntity(PerfilEmpresaDto perfilEmpresaPDto);
}
