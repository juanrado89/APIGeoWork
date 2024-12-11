package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.PerfilUsuarioPDto;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TrabajadorMapper.class,FotoMapper.class, OfertaEmpleoMapper.class, HorarioEntrevistaMapper.class})
public interface PerfilUsuarioPMapper {


    @Mapping(source = "idPerfil", target = "idPerfil")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "trabajador", target = "trabajador")
    @Mapping(source = "foto", target = "foto")
    @Mapping(source = "ofertas", target = "ofertas")
    @Mapping(source = "horarios", target = "horarios")



    PerfilUsuarioPDto toDto(PerfilUsuario perfilUsuario);
    PerfilUsuario toEntity(PerfilUsuarioPDto perfilUsuarioPDto);
}

