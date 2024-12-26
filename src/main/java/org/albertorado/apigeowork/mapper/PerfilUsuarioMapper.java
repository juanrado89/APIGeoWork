package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.configuracion.EvitarCiclosMapping;
import org.albertorado.apigeowork.dtos.PerfilUsuarioDto;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TrabajadorMapper.class,FotoMapper.class, OfertaEmpleoMapper.class, HorarioEntrevistaMapper.class})
public interface PerfilUsuarioMapper {

    @Mapping(source = "idPerfil", target = "idPerfil")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "trabajador", target = "trabajador")
    @Mapping(source = "foto", target = "foto")
    @Mapping(source = "ofertas", target = "ofertas")
    @Mapping(source = "horarios", target = "horarios")


    PerfilUsuarioDto toDto(PerfilUsuario perfilUsuario, @Context EvitarCiclosMapping contexto);
    PerfilUsuario toEntity(PerfilUsuarioDto perfilUsuarioDto,@Context EvitarCiclosMapping contexto);

    List<PerfilUsuarioDto> toDto(List<PerfilUsuario> perfiles,@Context EvitarCiclosMapping contexto);
}
