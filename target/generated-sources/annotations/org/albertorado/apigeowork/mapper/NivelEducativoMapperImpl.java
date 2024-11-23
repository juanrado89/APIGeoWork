package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.NivelEducativoDto;
import org.albertorado.apigeowork.entities.NivelEducativo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T13:22:15+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class NivelEducativoMapperImpl implements NivelEducativoMapper {

    @Autowired
    private NivelMapper nivelMapper;

    @Override
    public NivelEducativoDto toDto(NivelEducativo nivelEducativo) {
        if ( nivelEducativo == null ) {
            return null;
        }

        NivelEducativoDto nivelEducativoDto = new NivelEducativoDto();

        nivelEducativoDto.setIdNivelEducativo( nivelEducativo.getIdNivelEducativo() );
        nivelEducativoDto.setTituloNivelEducativo( nivelEducativo.getTituloNivelEducativo() );
        nivelEducativoDto.setCentroEducativo( nivelEducativo.getCentroEducativo() );
        nivelEducativoDto.setFechaInicio( nivelEducativo.getFechaInicio() );
        nivelEducativoDto.setFechaFin( nivelEducativo.getFechaFin() );
        nivelEducativoDto.setNivel( nivelMapper.toDto( nivelEducativo.getNivel() ) );

        return nivelEducativoDto;
    }

    @Override
    public NivelEducativo toEntity(NivelEducativoDto nivelEducativoDto) {
        if ( nivelEducativoDto == null ) {
            return null;
        }

        NivelEducativo nivelEducativo = new NivelEducativo();

        nivelEducativo.setIdNivelEducativo( nivelEducativoDto.getIdNivelEducativo() );
        nivelEducativo.setTituloNivelEducativo( nivelEducativoDto.getTituloNivelEducativo() );
        nivelEducativo.setCentroEducativo( nivelEducativoDto.getCentroEducativo() );
        nivelEducativo.setFechaInicio( nivelEducativoDto.getFechaInicio() );
        nivelEducativo.setFechaFin( nivelEducativoDto.getFechaFin() );
        nivelEducativo.setNivel( nivelMapper.toEntity( nivelEducativoDto.getNivel() ) );

        return nivelEducativo;
    }

    @Override
    public List<NivelEducativoDto> toDto(List<NivelEducativo> nivelEducativo) {
        if ( nivelEducativo == null ) {
            return null;
        }

        List<NivelEducativoDto> list = new ArrayList<NivelEducativoDto>( nivelEducativo.size() );
        for ( NivelEducativo nivelEducativo1 : nivelEducativo ) {
            list.add( toDto( nivelEducativo1 ) );
        }

        return list;
    }
}
