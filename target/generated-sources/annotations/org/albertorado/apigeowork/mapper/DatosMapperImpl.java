package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.DatosDto;
import org.albertorado.apigeowork.entities.Datos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T13:22:16+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class DatosMapperImpl implements DatosMapper {

    @Autowired
    private DireccionMapper direccionMapper;

    @Override
    public DatosDto toDto(Datos datos) {
        if ( datos == null ) {
            return null;
        }

        DatosDto datosDto = new DatosDto();

        datosDto.setIdDatos( datos.getIdDatos() );
        datosDto.setNombre( datos.getNombre() );
        datosDto.setApellidos( datos.getApellidos() );
        datosDto.setTelefono( datos.getTelefono() );
        datosDto.setFechaEdad( datos.getFechaEdad() );
        datosDto.setDireccion( direccionMapper.toDto( datos.getDireccion() ) );

        return datosDto;
    }

    @Override
    public Datos toEntity(DatosDto dto) {
        if ( dto == null ) {
            return null;
        }

        Datos datos = new Datos();

        datos.setIdDatos( dto.getIdDatos() );
        datos.setNombre( dto.getNombre() );
        datos.setApellidos( dto.getApellidos() );
        datos.setFechaEdad( dto.getFechaEdad() );
        datos.setDireccion( direccionMapper.toEntity( dto.getDireccion() ) );
        datos.setTelefono( dto.getTelefono() );

        return datos;
    }
}
