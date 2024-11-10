package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.EstadoDto;
import org.albertorado.apigeowork.entities.Estado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PaisMapper.class})
public interface EstadoMapper {

    @Mapping(source = "idEstado", target = "idEstado")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "pais", target = "pais")

    EstadoDto toDto(Estado estado);
    Estado toEntity(EstadoDto estadoDto);

    List<EstadoDto> toDto(List<Estado> resultado);
}
