package org.albertorado.apigeowork.mapper;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.DocumentoDto;
import org.albertorado.apigeowork.entities.Documento;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-14T12:00:21+0100",
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
        byte[] contenido = documento.getContenido();
        if ( contenido != null ) {
            documentoDto.setContenido( Arrays.copyOf( contenido, contenido.length ) );
        }

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
        byte[] contenido = documentoDto.getContenido();
        if ( contenido != null ) {
            documento.setContenido( Arrays.copyOf( contenido, contenido.length ) );
        }

        return documento;
    }
}
