package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.PerfilUsuarioPDto;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T21:49:38+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class PerfilUsuarioPMapperImpl implements PerfilUsuarioPMapper {

    @Autowired
    private TrabajadorMapper trabajadorMapper;
    @Autowired
    private FotoMapper fotoMapper;

    @Override
    public PerfilUsuarioPDto toDto(PerfilUsuario perfilUsuario) {
        if ( perfilUsuario == null ) {
            return null;
        }

        PerfilUsuarioPDto perfilUsuarioPDto = new PerfilUsuarioPDto();

        perfilUsuarioPDto.setIdPerfil( perfilUsuario.getIdPerfil() );
        perfilUsuarioPDto.setPassword( perfilUsuario.getPassword() );
        perfilUsuarioPDto.setEmail( perfilUsuario.getEmail() );
        perfilUsuarioPDto.setTrabajador( trabajadorMapper.toDto( perfilUsuario.getTrabajador() ) );
        perfilUsuarioPDto.setFoto( fotoMapper.toDto( perfilUsuario.getFoto() ) );

        return perfilUsuarioPDto;
    }

    @Override
    public PerfilUsuario toEntity(PerfilUsuarioPDto perfilUsuarioPDto) {
        if ( perfilUsuarioPDto == null ) {
            return null;
        }

        PerfilUsuario perfilUsuario = new PerfilUsuario();

        perfilUsuario.setIdPerfil( perfilUsuarioPDto.getIdPerfil() );
        perfilUsuario.setPassword( perfilUsuarioPDto.getPassword() );
        perfilUsuario.setTrabajador( trabajadorMapper.toEntity( perfilUsuarioPDto.getTrabajador() ) );
        perfilUsuario.setEmail( perfilUsuarioPDto.getEmail() );
        perfilUsuario.setFoto( fotoMapper.toEntity( perfilUsuarioPDto.getFoto() ) );

        return perfilUsuario;
    }
}
