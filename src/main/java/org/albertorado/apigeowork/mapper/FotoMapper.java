package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.FotoDto;
import org.albertorado.apigeowork.entities.Foto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FotoMapper {
    FotoDto ToDto(Foto foto);
    Foto ToEntity(FotoDto fotoDto);
}
