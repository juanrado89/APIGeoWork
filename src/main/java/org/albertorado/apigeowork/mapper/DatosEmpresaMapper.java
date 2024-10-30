package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.DatosEmpresaDto;
import org.albertorado.apigeowork.entities.DatosEmpresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DireccionMapper.class, SectorMapper.class})
public interface DatosEmpresaMapper {

    @Mapping(source = "idDatosEmpresa", target = "idDatosEmpresa")
    @Mapping(source = "nombreEmpresa", target = "nombreEmpresa")
    @Mapping(source = "contactoNombre", target = "contactoNombre")
    @Mapping(source = "contactoEmail", target = "contactoEmail")
    @Mapping(source = "contactoTelefono", target = "contactoTelefono")
    @Mapping(source = "sitioWeb", target = "sitioWeb")
    @Mapping(source = "fechaRegistro", target = "fechaRegistro")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "sector", target = "sector")

    DatosEmpresaDto toDto(DatosEmpresa entity);
    DatosEmpresa toEntity(DatosEmpresaDto dto);
}
