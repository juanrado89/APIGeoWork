package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-05T21:24:02+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ExperienciaTotalMapperImpl implements ExperienciaTotalMapper {

    @Override
    public ExperienciaTotalDto toDto(ExperienciaTotal experienciaTotal) {
        if ( experienciaTotal == null ) {
            return null;
        }

        ExperienciaTotalDto experienciaTotalDto = new ExperienciaTotalDto();

        experienciaTotalDto.setIdExperienciaTotal( experienciaTotal.getIdExperienciaTotal() );

        return experienciaTotalDto;
    }

    @Override
    public ExperienciaTotal toEntity(ExperienciaTotalDto experienciaTotalDto) {
        if ( experienciaTotalDto == null ) {
            return null;
        }

        ExperienciaTotal experienciaTotal = new ExperienciaTotal();

        experienciaTotal.setIdExperienciaTotal( experienciaTotalDto.getIdExperienciaTotal() );

        return experienciaTotal;
    }
}
