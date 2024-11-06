package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.EstadoDto;
import org.albertorado.apigeowork.entities.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T21:49:39+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
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
}
