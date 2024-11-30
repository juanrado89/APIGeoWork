package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.OfertaEmpleoDto;
import org.albertorado.apigeowork.entities.OfertaEmpleo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-23T14:24:37+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class OfertaEmpleoMapperImpl implements OfertaEmpleoMapper {

    @Autowired
    private EmpresaMapper empresaMapper;
    @Autowired
    private DireccionMapper direccionMapper;
    @Autowired
    private NivelMapper nivelMapper;
    @Autowired
    private SectorMapper sectorMapper;

    @Override
    public OfertaEmpleoDto toDto(OfertaEmpleo ofertaEmpleo) {
        if ( ofertaEmpleo == null ) {
            return null;
        }

        OfertaEmpleoDto ofertaEmpleoDto = new OfertaEmpleoDto();

        ofertaEmpleoDto.setIdOferta( ofertaEmpleo.getIdOferta() );
        ofertaEmpleoDto.setEmpresa( empresaMapper.toDto( ofertaEmpleo.getEmpresa() ) );
        ofertaEmpleoDto.setTitulo( ofertaEmpleo.getTitulo() );
        ofertaEmpleoDto.setCantidad( ofertaEmpleo.getCantidad() );
        ofertaEmpleoDto.setDescripcion( ofertaEmpleo.getDescripcion() );
        ofertaEmpleoDto.setSector( sectorMapper.toDto( ofertaEmpleo.getSector() ) );
        ofertaEmpleoDto.setRequisitos( ofertaEmpleo.getRequisitos() );
        ofertaEmpleoDto.setSalarioMin( ofertaEmpleo.getSalarioMin() );
        ofertaEmpleoDto.setSalarioMax( ofertaEmpleo.getSalarioMax() );
        ofertaEmpleoDto.setFechaPublicacion( ofertaEmpleo.getFechaPublicacion() );
        ofertaEmpleoDto.setEstado( ofertaEmpleo.getEstado() );
        ofertaEmpleoDto.setDireccion( direccionMapper.toDto( ofertaEmpleo.getDireccion() ) );
        ofertaEmpleoDto.setNivel( nivelMapper.toDto( ofertaEmpleo.getNivel() ) );

        return ofertaEmpleoDto;
    }

    @Override
    public OfertaEmpleo toEntity(OfertaEmpleoDto ofertaEmpleoDto) {
        if ( ofertaEmpleoDto == null ) {
            return null;
        }

        OfertaEmpleo ofertaEmpleo = new OfertaEmpleo();

        ofertaEmpleo.setIdOferta( ofertaEmpleoDto.getIdOferta() );
        ofertaEmpleo.setEmpresa( empresaMapper.toEntity( ofertaEmpleoDto.getEmpresa() ) );
        ofertaEmpleo.setTitulo( ofertaEmpleoDto.getTitulo() );
        ofertaEmpleo.setCantidad( ofertaEmpleoDto.getCantidad() );
        ofertaEmpleo.setDescripcion( ofertaEmpleoDto.getDescripcion() );
        ofertaEmpleo.setSector( sectorMapper.toEntity( ofertaEmpleoDto.getSector() ) );
        ofertaEmpleo.setRequisitos( ofertaEmpleoDto.getRequisitos() );
        ofertaEmpleo.setNivelEducativo( nivelMapper.toEntity( ofertaEmpleoDto.getNivel() ) );
        ofertaEmpleo.setSalarioMin( ofertaEmpleoDto.getSalarioMin() );
        ofertaEmpleo.setSalarioMax( ofertaEmpleoDto.getSalarioMax() );
        ofertaEmpleo.setDireccion( direccionMapper.toEntity( ofertaEmpleoDto.getDireccion() ) );
        ofertaEmpleo.setFechaPublicacion( ofertaEmpleoDto.getFechaPublicacion() );
        ofertaEmpleo.setEstado( ofertaEmpleoDto.getEstado() );

        return ofertaEmpleo;
    }

    @Override
    public List<OfertaEmpleoDto> toDto(List<OfertaEmpleo> ofertas) {
        if ( ofertas == null ) {
            return null;
        }

        List<OfertaEmpleoDto> list = new ArrayList<OfertaEmpleoDto>( ofertas.size() );
        for ( OfertaEmpleo ofertaEmpleo : ofertas ) {
            list.add( toDto( ofertaEmpleo ) );
        }

        return list;
    }
}
