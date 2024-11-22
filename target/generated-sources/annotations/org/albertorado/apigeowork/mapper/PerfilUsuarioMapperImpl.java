package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.PerfilUsuarioDto;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T08:49:32+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class PerfilUsuarioMapperImpl implements PerfilUsuarioMapper {

    @Autowired
    private TrabajadorMapper trabajadorMapper;
    @Autowired
    private FotoMapper fotoMapper;

    @Override
    public PerfilUsuarioDto toDto(PerfilUsuario perfilUsuario) {
        if ( perfilUsuario == null ) {
            return null;
        }

        PerfilUsuarioDto perfilUsuarioDto = new PerfilUsuarioDto();

        perfilUsuarioDto.setIdPerfil( perfilUsuario.getIdPerfil() );
        perfilUsuarioDto.setEmail( perfilUsuario.getEmail() );
        perfilUsuarioDto.setTrabajador( trabajadorMapper.toDto( perfilUsuario.getTrabajador() ) );
        perfilUsuarioDto.setFoto( fotoMapper.toDto( perfilUsuario.getFoto() ) );

        return perfilUsuarioDto;
    }

    @Override
    public PerfilUsuario toEntity(PerfilUsuarioDto perfilUsuarioDto) {
        if ( perfilUsuarioDto == null ) {
            return null;
        }

        PerfilUsuario perfilUsuario = new PerfilUsuario();

        perfilUsuario.setIdPerfil( perfilUsuarioDto.getIdPerfil() );
        perfilUsuario.setTrabajador( trabajadorMapper.toEntity( perfilUsuarioDto.getTrabajador() ) );
        perfilUsuario.setEmail( perfilUsuarioDto.getEmail() );
        perfilUsuario.setFoto( fotoMapper.toEntity( perfilUsuarioDto.getFoto() ) );

        return perfilUsuario;
    }
}
