package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.NivelDto;
import org.albertorado.apigeowork.entities.Nivel;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T20:53:35+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
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
}
