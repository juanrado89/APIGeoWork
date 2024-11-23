package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.TrabajadorDto;
import org.albertorado.apigeowork.entities.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-23T14:24:37+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class TrabajadorMapperImpl implements TrabajadorMapper {

    @Autowired
    private DatosMapper datosMapper;
    @Autowired
    private ExperienciaMapper experienciaMapper;

    @Override
    public TrabajadorDto toDto(Trabajador trabajador) {
        if ( trabajador == null ) {
            return null;
        }

        TrabajadorDto trabajadorDto = new TrabajadorDto();

        trabajadorDto.setIdTrabajador( trabajador.getIdTrabajador() );
        trabajadorDto.setDatosUsuario( datosMapper.toDto( trabajador.getDatosUsuario() ) );
        trabajadorDto.setDatosExperiencia( experienciaMapper.toDto( trabajador.getDatosExperiencia() ) );

        return trabajadorDto;
    }

    @Override
    public Trabajador toEntity(TrabajadorDto trabajadorDto) {
        if ( trabajadorDto == null ) {
            return null;
        }

        Trabajador trabajador = new Trabajador();

        trabajador.setIdTrabajador( trabajadorDto.getIdTrabajador() );
        trabajador.setDatosUsuario( datosMapper.toEntity( trabajadorDto.getDatosUsuario() ) );
        trabajador.setDatosExperiencia( experienciaMapper.toEntity( trabajadorDto.getDatosExperiencia() ) );

        return trabajador;
    }
}
