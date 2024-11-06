package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.PaisDto;
import org.albertorado.apigeowork.entities.Pais;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T21:49:39+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class PaisMapperImpl implements PaisMapper {

    @Override
    public PaisDto toDto(Pais pais) {
        if ( pais == null ) {
            return null;
        }

        PaisDto paisDto = new PaisDto();

        paisDto.setIdPais( pais.getIdPais() );
        paisDto.setPais( pais.getPais() );

        return paisDto;
    }

    @Override
    public Pais toEntity(PaisDto paisDto) {
        if ( paisDto == null ) {
            return null;
        }

        Pais pais = new Pais();

        pais.setIdPais( paisDto.getIdPais() );
        pais.setPais( paisDto.getPais() );

        return pais;
    }
}
