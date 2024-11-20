package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.PaisDto;
import org.albertorado.apigeowork.entities.Pais;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-14T12:00:21+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
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

    @Override
    public List<PaisDto> toDto(List<Pais> resultado) {
        if ( resultado == null ) {
            return null;
        }

        List<PaisDto> list = new ArrayList<PaisDto>( resultado.size() );
        for ( Pais pais : resultado ) {
            list.add( toDto( pais ) );
        }

        return list;
    }
}
