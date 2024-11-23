package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.DireccionDto;
import org.albertorado.apigeowork.entities.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-23T14:24:37+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class DireccionMapperImpl implements DireccionMapper {

    @Autowired
    private CiudadMapper ciudadMapper;

    @Override
    public DireccionDto toDto(Direccion direccion) {
        if ( direccion == null ) {
            return null;
        }

        DireccionDto direccionDto = new DireccionDto();

        direccionDto.setIdDireccion( direccion.getIdDireccion() );
        direccionDto.setDireccion( direccion.getDireccion() );
        direccionDto.setPiso( direccion.getPiso() );
        direccionDto.setPuerta( direccion.getPuerta() );
        direccionDto.setCodigoPostal( direccion.getCodigoPostal() );
        direccionDto.setCiudad( ciudadMapper.toDto( direccion.getCiudad() ) );

        return direccionDto;
    }

    @Override
    public Direccion toEntity(DireccionDto direccionDto) {
        if ( direccionDto == null ) {
            return null;
        }

        Direccion direccion = new Direccion();

        direccion.setIdDireccion( direccionDto.getIdDireccion() );
        direccion.setDireccion( direccionDto.getDireccion() );
        direccion.setPiso( direccionDto.getPiso() );
        direccion.setPuerta( direccionDto.getPuerta() );
        direccion.setCiudad( ciudadMapper.toEntity( direccionDto.getCiudad() ) );
        direccion.setCodigoPostal( direccionDto.getCodigoPostal() );

        return direccion;
    }
}
