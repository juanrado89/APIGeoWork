package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.NivelDto;
import org.albertorado.apigeowork.entities.Nivel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-02T11:22:00+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class NivelMapperImpl implements NivelMapper {

    @Override
    public NivelDto toDto(Nivel nivel) {
        if ( nivel == null ) {
            return null;
        }

        NivelDto nivelDto = new NivelDto();

        nivelDto.setIdNivel( nivel.getIdNivel() );
        nivelDto.setNombreNivel( nivel.getNombreNivel() );

        return nivelDto;
    }

    @Override
    public Nivel toEntity(NivelDto nivelDto) {
        if ( nivelDto == null ) {
            return null;
        }

        Nivel nivel = new Nivel();

        nivel.setIdNivel( nivelDto.getIdNivel() );
        nivel.setNombreNivel( nivelDto.getNombreNivel() );

        return nivel;
    }

    @Override
    public List<NivelDto> toDto(List<Nivel> resultado) {
        if ( resultado == null ) {
            return null;
        }

        List<NivelDto> list = new ArrayList<NivelDto>( resultado.size() );
        for ( Nivel nivel : resultado ) {
            list.add( toDto( nivel ) );
        }

        return list;
    }
}
