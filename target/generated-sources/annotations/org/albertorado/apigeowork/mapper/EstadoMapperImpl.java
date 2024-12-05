package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.EstadoDto;
import org.albertorado.apigeowork.entities.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-05T09:33:02+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class EstadoMapperImpl implements EstadoMapper {

    @Autowired
    private PaisMapper paisMapper;

    @Override
    public EstadoDto toDto(Estado estado) {
        if ( estado == null ) {
            return null;
        }

        EstadoDto estadoDto = new EstadoDto();

        estadoDto.setIdEstado( estado.getIdEstado() );
        estadoDto.setEstado( estado.getEstado() );
        estadoDto.setPais( paisMapper.toDto( estado.getPais() ) );

        return estadoDto;
    }

    @Override
    public Estado toEntity(EstadoDto estadoDto) {
        if ( estadoDto == null ) {
            return null;
        }

        Estado estado = new Estado();

        estado.setIdEstado( estadoDto.getIdEstado() );
        estado.setEstado( estadoDto.getEstado() );
        estado.setPais( paisMapper.toEntity( estadoDto.getPais() ) );

        return estado;
    }

    @Override
    public List<EstadoDto> toDto(List<Estado> resultado) {
        if ( resultado == null ) {
            return null;
        }

        List<EstadoDto> list = new ArrayList<EstadoDto>( resultado.size() );
        for ( Estado estado : resultado ) {
            list.add( toDto( estado ) );
        }

        return list;
    }
}
