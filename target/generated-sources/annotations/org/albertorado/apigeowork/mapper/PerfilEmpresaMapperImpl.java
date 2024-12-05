package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.PerfilEmpresaDto;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-05T09:33:02+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class PerfilEmpresaMapperImpl implements PerfilEmpresaMapper {

    @Autowired
    private EmpresaMapper empresaMapper;
    @Autowired
    private FotoMapper fotoMapper;

    @Override
    public PerfilEmpresaDto toDto(PerfilEmpresa perfilEmpresa) {
        if ( perfilEmpresa == null ) {
            return null;
        }

        PerfilEmpresaDto perfilEmpresaDto = new PerfilEmpresaDto();

        perfilEmpresaDto.setIdUsuario( perfilEmpresa.getIdUsuario() );
        perfilEmpresaDto.setEmail( perfilEmpresa.getEmail() );
        perfilEmpresaDto.setEmpresa( empresaMapper.toDto( perfilEmpresa.getEmpresa() ) );
        perfilEmpresaDto.setFoto( fotoMapper.toDto( perfilEmpresa.getFoto() ) );

        return perfilEmpresaDto;
    }

    @Override
    public PerfilEmpresa toEntity(PerfilEmpresaDto perfilEmpresaPDto) {
        if ( perfilEmpresaPDto == null ) {
            return null;
        }

        PerfilEmpresa perfilEmpresa = new PerfilEmpresa();

        perfilEmpresa.setIdUsuario( perfilEmpresaPDto.getIdUsuario() );
        perfilEmpresa.setEmpresa( empresaMapper.toEntity( perfilEmpresaPDto.getEmpresa() ) );
        perfilEmpresa.setEmail( perfilEmpresaPDto.getEmail() );
        perfilEmpresa.setFoto( fotoMapper.toEntity( perfilEmpresaPDto.getFoto() ) );

        return perfilEmpresa;
    }
}
