package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.DescripcionExperienciaDto;
import org.albertorado.apigeowork.dtos.ExperienciaDto;
import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.dtos.SectorDto;
import org.albertorado.apigeowork.entities.DescripcionExperiencia;
import org.albertorado.apigeowork.entities.Experiencia;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.albertorado.apigeowork.entities.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T21:49:38+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
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
        experienciaDto.setSector( sectorListToSectorDtoList( experiencia.getSector() ) );
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

    protected List<SectorDto> sectorListToSectorDtoList(List<Sector> list) {
        if ( list == null ) {
            return null;
        }

        List<SectorDto> list1 = new ArrayList<SectorDto>( list.size() );
        for ( Sector sector : list ) {
            list1.add( sectorMapper.toDto( sector ) );
        }

        return list1;
    }

    protected DescripcionExperienciaDto descripcionExperienciaToDescripcionExperienciaDto(DescripcionExperiencia descripcionExperiencia) {
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

    protected List<DescripcionExperienciaDto> descripcionExperienciaListToDescripcionExperienciaDtoList(List<DescripcionExperiencia> list) {
        if ( list == null ) {
            return null;
        }

        List<DescripcionExperienciaDto> list1 = new ArrayList<DescripcionExperienciaDto>( list.size() );
        for ( DescripcionExperiencia descripcionExperiencia : list ) {
            list1.add( descripcionExperienciaToDescripcionExperienciaDto( descripcionExperiencia ) );
        }

        return list1;
    }

    protected ExperienciaTotalDto experienciaTotalToExperienciaTotalDto(ExperienciaTotal experienciaTotal) {
        if ( experienciaTotal == null ) {
            return null;
        }

        ExperienciaTotalDto experienciaTotalDto = new ExperienciaTotalDto();

        experienciaTotalDto.setIdExperienciaTotal( experienciaTotal.getIdExperienciaTotal() );
        experienciaTotalDto.setDescripcionExperiencia( descripcionExperienciaListToDescripcionExperienciaDtoList( experienciaTotal.getDescripcionExperiencia() ) );

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

    protected DescripcionExperiencia descripcionExperienciaDtoToDescripcionExperiencia(DescripcionExperienciaDto descripcionExperienciaDto) {
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

    protected List<DescripcionExperiencia> descripcionExperienciaDtoListToDescripcionExperienciaList(List<DescripcionExperienciaDto> list) {
        if ( list == null ) {
            return null;
        }

        List<DescripcionExperiencia> list1 = new ArrayList<DescripcionExperiencia>( list.size() );
        for ( DescripcionExperienciaDto descripcionExperienciaDto : list ) {
            list1.add( descripcionExperienciaDtoToDescripcionExperiencia( descripcionExperienciaDto ) );
        }

        return list1;
    }

    protected ExperienciaTotal experienciaTotalDtoToExperienciaTotal(ExperienciaTotalDto experienciaTotalDto) {
        if ( experienciaTotalDto == null ) {
            return null;
        }

        ExperienciaTotal experienciaTotal = new ExperienciaTotal();

        experienciaTotal.setIdExperienciaTotal( experienciaTotalDto.getIdExperienciaTotal() );
        experienciaTotal.setDescripcionExperiencia( descripcionExperienciaDtoListToDescripcionExperienciaList( experienciaTotalDto.getDescripcionExperiencia() ) );

        return experienciaTotal;
    }
}
