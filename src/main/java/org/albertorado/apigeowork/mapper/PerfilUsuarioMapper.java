package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.PerfilUsuarioDto;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PerfilUsuarioMapper {
    PerfilUsuarioDto toDto(PerfilUsuario perfilUsuario);
    PerfilUsuario toEntity(PerfilUsuarioDto perfilUsuarioDto);
}
