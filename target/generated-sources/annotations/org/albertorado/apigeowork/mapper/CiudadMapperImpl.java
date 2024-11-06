package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.CiudadDto;
import org.albertorado.apigeowork.entities.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T20:53:35+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
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
}
