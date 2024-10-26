package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.DocumentoDto;
import org.albertorado.apigeowork.entities.Documento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {
    DocumentoDto toDto(Documento documento);
    Documento toEntity(DocumentoDto documentoDto);
}
