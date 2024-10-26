package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.EmpresaDto;
import org.albertorado.apigeowork.entities.Empresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {
    EmpresaDto toDto(Empresa empresa);
    Empresa toEmntity(EmpresaDto empresaDto);
}
