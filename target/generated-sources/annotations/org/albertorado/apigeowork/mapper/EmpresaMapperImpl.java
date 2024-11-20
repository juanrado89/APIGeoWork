package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.EmpresaDto;
import org.albertorado.apigeowork.entities.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-14T12:00:21+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class EmpresaMapperImpl implements EmpresaMapper {

    @Autowired
    private DatosEmpresaMapper datosEmpresaMapper;

    @Override
    public EmpresaDto toDto(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        EmpresaDto empresaDto = new EmpresaDto();

        empresaDto.setIdEmpresa( empresa.getIdEmpresa() );
        empresaDto.setDatosEmpresa( datosEmpresaMapper.toDto( empresa.getDatosEmpresa() ) );

        return empresaDto;
    }

    @Override
    public Empresa toEntity(EmpresaDto empresaDto) {
        if ( empresaDto == null ) {
            return null;
        }

        Empresa empresa = new Empresa();

        empresa.setIdEmpresa( empresaDto.getIdEmpresa() );
        empresa.setDatosEmpresa( datosEmpresaMapper.toEntity( empresaDto.getDatosEmpresa() ) );

        return empresa;
    }
}
