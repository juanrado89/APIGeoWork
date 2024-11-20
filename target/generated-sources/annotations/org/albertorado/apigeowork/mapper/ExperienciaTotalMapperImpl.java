package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.DescripcionExperienciaDto;
import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.entities.DescripcionExperiencia;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-14T12:00:21+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ExperienciaTotalMapperImpl implements ExperienciaTotalMapper {

    @Autowired
    private DescripcionExperienciaMapper descripcionExperienciaMapper;

    @Override
    public ExperienciaTotalDto toDto(ExperienciaTotal experienciaTotal) {
        if ( experienciaTotal == null ) {
            return null;
        }

        ExperienciaTotalDto experienciaTotalDto = new ExperienciaTotalDto();

        experienciaTotalDto.setIdExperienciaTotal( experienciaTotal.getIdExperienciaTotal() );
        experienciaTotalDto.setDescripcionExperiencia( descripcionExperienciaListToDescripcionExperienciaDtoList( experienciaTotal.getDescripcionExperiencia() ) );

        return experienciaTotalDto;
    }

    @Override
    public ExperienciaTotal toEntity(ExperienciaTotalDto experienciaTotalDto) {
        if ( experienciaTotalDto == null ) {
            return null;
        }

        ExperienciaTotal experienciaTotal = new ExperienciaTotal();

        experienciaTotal.setIdExperienciaTotal( experienciaTotalDto.getIdExperienciaTotal() );
        experienciaTotal.setDescripcionExperiencia( descripcionExperienciaDtoListToDescripcionExperienciaList( experienciaTotalDto.getDescripcionExperiencia() ) );

        return experienciaTotal;
    }

    protected List<DescripcionExperienciaDto> descripcionExperienciaListToDescripcionExperienciaDtoList(List<DescripcionExperiencia> list) {
        if ( list == null ) {
            return null;
        }

        List<DescripcionExperienciaDto> list1 = new ArrayList<DescripcionExperienciaDto>( list.size() );
        for ( DescripcionExperiencia descripcionExperiencia : list ) {
            list1.add( descripcionExperienciaMapper.toDto( descripcionExperiencia ) );
        }

        return list1;
    }

    protected List<DescripcionExperiencia> descripcionExperienciaDtoListToDescripcionExperienciaList(List<DescripcionExperienciaDto> list) {
        if ( list == null ) {
            return null;
        }

        List<DescripcionExperiencia> list1 = new ArrayList<DescripcionExperiencia>( list.size() );
        for ( DescripcionExperienciaDto descripcionExperienciaDto : list ) {
            list1.add( descripcionExperienciaMapper.toEntity( descripcionExperienciaDto ) );
        }

        return list1;
    }
}
