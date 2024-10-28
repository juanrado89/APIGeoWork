package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.PerfilEmpresaDto;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EmpresaMapper.class, FotoMapper.class})
public interface PerfilEmpresaMapper {

    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "empresa", target = "empresaDto")
    @Mapping(source = "sector", target = "sectorDto")
    @Mapping(source = "foto", target = "fotoDto")

    PerfilEmpresaDto toDto(PerfilEmpresa perfilEmpresa);
    PerfilEmpresa toEntity(PerfilEmpresaDto perfilEmpresaPDto);
}
