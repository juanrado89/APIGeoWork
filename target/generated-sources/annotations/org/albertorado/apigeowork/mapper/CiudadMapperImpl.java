package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.CiudadDto;
import org.albertorado.apigeowork.entities.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-05T21:24:02+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class CiudadMapperImpl implements CiudadMapper {

    @Autowired
    private EstadoMapper estadoMapper;

    @Override
    public CiudadDto toDto(Ciudad ciudad) {
        if ( ciudad == null ) {
            return null;
        }

        CiudadDto ciudadDto = new CiudadDto();

        ciudadDto.setIdCiudad( ciudad.getIdCiudad() );
        ciudadDto.setCiudad( ciudad.getCiudad() );
        ciudadDto.setEstado( estadoMapper.toDto( ciudad.getEstado() ) );

        return ciudadDto;
    }

    @Override
    public Ciudad toEntity(CiudadDto ciudadDto) {
        if ( ciudadDto == null ) {
            return null;
        }

        Ciudad ciudad = new Ciudad();

        ciudad.setIdCiudad( ciudadDto.getIdCiudad() );
        ciudad.setCiudad( ciudadDto.getCiudad() );
        ciudad.setEstado( estadoMapper.toEntity( ciudadDto.getEstado() ) );

        return ciudad;
    }

    @Override
    public List<CiudadDto> toDto(List<Ciudad> resultado) {
        if ( resultado == null ) {
            return null;
        }

        List<CiudadDto> list = new ArrayList<CiudadDto>( resultado.size() );
        for ( Ciudad ciudad : resultado ) {
            list.add( toDto( ciudad ) );
        }

        return list;
    }
}
