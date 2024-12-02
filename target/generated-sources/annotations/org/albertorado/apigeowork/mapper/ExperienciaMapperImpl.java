package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.ExperienciaDto;
import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.dtos.SectorDto;
import org.albertorado.apigeowork.entities.Experiencia;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.albertorado.apigeowork.entities.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-02T11:22:00+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ExperienciaMapperImpl implements ExperienciaMapper {

    @Autowired
    private NivelEducativoMapper nivelEducativoMapper;
    @Autowired
    private DocumentoMapper documentoMapper;
    @Autowired
    private SectorMapper sectorMapper;

    @Override
    public ExperienciaDto toDto(Experiencia experiencia) {
        if ( experiencia == null ) {
            return null;
        }

        ExperienciaDto experienciaDto = new ExperienciaDto();

        experienciaDto.setIdExperiencia( experiencia.getIdExperiencia() );
        experienciaDto.setNivelEducativo( nivelEducativoMapper.toDto( experiencia.getNivelEducativo() ) );
        experienciaDto.setSector( sectorMapper.toDto( experiencia.getSector() ) );
        experienciaDto.setExperienciaTotal( experienciaTotalToExperienciaTotalDto( experiencia.getExperienciaTotal() ) );
        experienciaDto.setCvUrl( documentoMapper.toDto( experiencia.getCvUrl() ) );
        experienciaDto.setFechaRegistro( experiencia.getFechaRegistro() );

        return experienciaDto;
    }

    @Override
    public Experiencia toEntity(ExperienciaDto experienciaDto) {
        if ( experienciaDto == null ) {
            return null;
        }

        Experiencia experiencia = new Experiencia();

        experiencia.setIdExperiencia( experienciaDto.getIdExperiencia() );
        experiencia.setNivelEducativo( nivelEducativoMapper.toEntity( experienciaDto.getNivelEducativo() ) );
        experiencia.setSector( sectorDtoListToSectorList( experienciaDto.getSector() ) );
        experiencia.setExperienciaTotal( experienciaTotalDtoToExperienciaTotal( experienciaDto.getExperienciaTotal() ) );
        experiencia.setCvUrl( documentoMapper.toEntity( experienciaDto.getCvUrl() ) );
        experiencia.setFechaRegistro( experienciaDto.getFechaRegistro() );

        return experiencia;
    }

    @Override
    public List<ExperienciaDto> toDto(List<Experiencia> allBySectorSectorContainsIgnoreCase) {
        if ( allBySectorSectorContainsIgnoreCase == null ) {
            return null;
        }

        List<ExperienciaDto> list = new ArrayList<ExperienciaDto>( allBySectorSectorContainsIgnoreCase.size() );
        for ( Experiencia experiencia : allBySectorSectorContainsIgnoreCase ) {
            list.add( toDto( experiencia ) );
        }

        return list;
    }

    protected ExperienciaTotalDto experienciaTotalToExperienciaTotalDto(ExperienciaTotal experienciaTotal) {
        if ( experienciaTotal == null ) {
            return null;
        }

        ExperienciaTotalDto experienciaTotalDto = new ExperienciaTotalDto();

        experienciaTotalDto.setIdExperienciaTotal( experienciaTotal.getIdExperienciaTotal() );

        return experienciaTotalDto;
    }

    protected List<Sector> sectorDtoListToSectorList(List<SectorDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Sector> list1 = new ArrayList<Sector>( list.size() );
        for ( SectorDto sectorDto : list ) {
            list1.add( sectorMapper.toEntity( sectorDto ) );
        }

        return list1;
    }

    protected ExperienciaTotal experienciaTotalDtoToExperienciaTotal(ExperienciaTotalDto experienciaTotalDto) {
        if ( experienciaTotalDto == null ) {
            return null;
        }

        ExperienciaTotal experienciaTotal = new ExperienciaTotal();

        experienciaTotal.setIdExperienciaTotal( experienciaTotalDto.getIdExperienciaTotal() );

        return experienciaTotal;
    }
}
