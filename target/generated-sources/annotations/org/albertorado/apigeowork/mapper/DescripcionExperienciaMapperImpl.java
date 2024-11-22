package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.DescripcionExperienciaDto;
import org.albertorado.apigeowork.entities.DescripcionExperiencia;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T08:49:32+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class DescripcionExperienciaMapperImpl implements DescripcionExperienciaMapper {

    @Override
    public DescripcionExperienciaDto toDto(DescripcionExperiencia descripcionExperiencia) {
        if ( descripcionExperiencia == null ) {
            return null;
        }

        DescripcionExperienciaDto descripcionExperienciaDto = new DescripcionExperienciaDto();

        descripcionExperienciaDto.setIdDescripcionExperiencia( descripcionExperiencia.getIdDescripcionExperiencia() );
        descripcionExperienciaDto.setNombreEmpresa( descripcionExperiencia.getNombreEmpresa() );
        descripcionExperienciaDto.setDescripcion( descripcionExperiencia.getDescripcion() );
        descripcionExperienciaDto.setFechaInicio( descripcionExperiencia.getFechaInicio() );
        descripcionExperienciaDto.setFechaFin( descripcionExperiencia.getFechaFin() );

        return descripcionExperienciaDto;
    }

    @Override
    public DescripcionExperiencia toEntity(DescripcionExperienciaDto descripcionExperienciaDto) {
        if ( descripcionExperienciaDto == null ) {
            return null;
        }

        DescripcionExperiencia descripcionExperiencia = new DescripcionExperiencia();

        descripcionExperiencia.setIdDescripcionExperiencia( descripcionExperienciaDto.getIdDescripcionExperiencia() );
        descripcionExperiencia.setNombreEmpresa( descripcionExperienciaDto.getNombreEmpresa() );
        descripcionExperiencia.setDescripcion( descripcionExperienciaDto.getDescripcion() );
        descripcionExperiencia.setFechaInicio( descripcionExperienciaDto.getFechaInicio() );
        descripcionExperiencia.setFechaFin( descripcionExperienciaDto.getFechaFin() );

        return descripcionExperiencia;
    }

    @Override
    public List<DescripcionExperienciaDto> toDto(List<DescripcionExperiencia> creada) {
        if ( creada == null ) {
            return null;
        }

        List<DescripcionExperienciaDto> list = new ArrayList<DescripcionExperienciaDto>( creada.size() );
        for ( DescripcionExperiencia descripcionExperiencia : creada ) {
            list.add( toDto( descripcionExperiencia ) );
        }

        return list;
    }
}
