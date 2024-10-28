package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.FotoDto;
import org.albertorado.apigeowork.entities.Foto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FotoMapper {

    @Mapping(source = "idFoto", target = "idFoto")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "tipoContenido", target = "tipoContenido")
    @Mapping(source = "datos", target = "datos")
    FotoDto ToDto(Foto foto);
    Foto ToEntity(FotoDto fotoDto);
}
