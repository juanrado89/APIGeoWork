package org.albertorado.apigeowork.mapper;


import org.albertorado.apigeowork.dtos.OfertaEmpleoDto;
import org.albertorado.apigeowork.entities.OfertaEmpleo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfertaEmpleoMapper {
    OfertaEmpleoDto toDto(OfertaEmpleo ofertaEmpleo);
    OfertaEmpleo toEntity(OfertaEmpleoDto ofertaEmpleoDto);

    List<OfertaEmpleoDto> toDto(List<OfertaEmpleo> ofertas);
}
