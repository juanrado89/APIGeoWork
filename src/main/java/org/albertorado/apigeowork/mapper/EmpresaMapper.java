package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.EmpresaDto;
import org.albertorado.apigeowork.entities.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DatosEmpresaMapper.class})
public interface EmpresaMapper {

    @Mapping(source = "idEmpresa", target = "idEmpresa")
    @Mapping(source = "datosEmpresa", target = "datosEmpresa")

    EmpresaDto toDto(Empresa empresa);
    Empresa toEntity(EmpresaDto empresaDto);
}
