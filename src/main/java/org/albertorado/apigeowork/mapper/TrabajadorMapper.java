package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.TrabajadorDto;
import org.albertorado.apigeowork.entities.Trabajador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DatosMapper.class,ExperienciaMapper.class})
public interface TrabajadorMapper {

    @Mapping(source = "idTrabajador", target = "idTrabajador")
    @Mapping(source = "datos", target = "datos")
    @Mapping(source = "experiencia", target = "experiencia")

    TrabajadorDto toDto(Trabajador trabajador);
    Trabajador toEntity(TrabajadorDto trabajadorDto);
}
