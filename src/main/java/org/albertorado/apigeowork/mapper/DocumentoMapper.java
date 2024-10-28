package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.DocumentoDto;
import org.albertorado.apigeowork.entities.Documento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {

    @Mapping(source = "idDocumento", target = "idDocumento")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "tipoContenido", target = "tipoContenido")
    @Mapping(source = "contenido", target = "contenido")
    DocumentoDto toDto(Documento documento);
    Documento toEntity(DocumentoDto documentoDto);
}
