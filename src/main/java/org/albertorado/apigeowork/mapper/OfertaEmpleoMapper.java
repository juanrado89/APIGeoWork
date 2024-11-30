package org.albertorado.apigeowork.mapper;


import org.albertorado.apigeowork.dtos.OfertaEmpleoDto;
import org.albertorado.apigeowork.entities.OfertaEmpleo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EmpresaMapper.class,DireccionMapper.class, NivelMapper.class, HorarioEntrevistaMapper.class, SectorMapper.class, PerfilUsuarioMapper.class})
public interface OfertaEmpleoMapper {

    @Mapping(source = "idOferta", target = "idOferta")
    @Mapping(source = "empresa", target = "empresa")
    @Mapping(source = "titulo", target = "titulo")
    @Mapping(source = "cantidad", target = "cantidad")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "sector", target = "sector")
    @Mapping(source = "requisitos", target = "requisitos")
    @Mapping(source = "salarioMin", target = "salarioMin")
    @Mapping(source = "salarioMax", target = "salarioMax")
    @Mapping(source = "fechaPublicacion", target = "fechaPublicacion")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "nivel", target = "nivel")
    @Mapping(source = "trabajadores", target = "trabajadores")

    OfertaEmpleoDto toDto(OfertaEmpleo ofertaEmpleo);
    OfertaEmpleo toEntity(OfertaEmpleoDto ofertaEmpleoDto);

    List<OfertaEmpleoDto> toDto(List<OfertaEmpleo> ofertas);
}
