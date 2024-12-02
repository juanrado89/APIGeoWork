package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.PerfilUsuarioDto;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TrabajadorMapper.class,FotoMapper.class, OfertaEmpleoMapper.class})
public interface PerfilUsuarioMapper {

    @Mapping(source = "idPerfil", target = "idPerfil")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "trabajador", target = "trabajador")
    @Mapping(source = "foto", target = "foto")
    @Mapping(source = "ofertas", target = "ofertas")


    PerfilUsuarioDto toDto(PerfilUsuario perfilUsuario);
    PerfilUsuario toEntity(PerfilUsuarioDto perfilUsuarioDto);

    List<PerfilUsuarioDto> toDto(List<PerfilUsuario> perfiles);
}
