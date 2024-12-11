package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.DocumentoDto;
import org.albertorado.apigeowork.entities.Documento;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-11T19:14:53+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class DocumentoMapperImpl implements DocumentoMapper {

    @Override
    public DocumentoDto toDto(Documento documento) {
        if ( documento == null ) {
            return null;
        }

        DocumentoDto documentoDto = new DocumentoDto();

        documentoDto.setIdDocumento( (long) documento.getIdDocumento() );
        documentoDto.setNombre( documento.getNombre() );
        documentoDto.setTipoContenido( documento.getTipoContenido() );
        documentoDto.setContenido( documento.getContenido() );

        return documentoDto;
    }

    @Override
    public Documento toEntity(DocumentoDto documentoDto) {
        if ( documentoDto == null ) {
            return null;
        }

        Documento documento = new Documento();

        if ( documentoDto.getIdDocumento() != null ) {
            documento.setIdDocumento( documentoDto.getIdDocumento().intValue() );
        }
        documento.setNombre( documentoDto.getNombre() );
        documento.setTipoContenido( documentoDto.getTipoContenido() );
        documento.setContenido( documentoDto.getContenido() );

        return documento;
    }
}
