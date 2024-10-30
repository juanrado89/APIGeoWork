package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.PerfilEmpresaDto;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EmpresaMapper.class, FotoMapper.class, SectorMapper.class})
public interface PerfilEmpresaMapper {

    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "empresa", target = "empresa")
    @Mapping(source = "foto", target = "foto")

    PerfilEmpresaDto toDto(PerfilEmpresa perfilEmpresa);
    PerfilEmpresa toEntity(PerfilEmpresaDto perfilEmpresaPDto);
}
