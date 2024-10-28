package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.PerfilUsuarioDto;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TrabajadorMapper.class,FotoMapper.class})
public interface PerfilUsuarioMapper {

    @Mapping(source = "idPerfil", target = "idPerfil")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "trabajador", target = "trabajadorDto")
    @Mapping(source = "foto", target = "fotoDto")

    PerfilUsuarioDto toDto(PerfilUsuario perfilUsuario);
    PerfilUsuario toEntity(PerfilUsuarioDto perfilUsuarioDto);
}
