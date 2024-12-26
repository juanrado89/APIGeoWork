package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.configuracion.EvitarCiclosMapping;
import org.albertorado.apigeowork.dtos.HorarioEntrevistaDto;
import org.albertorado.apigeowork.entities.HorarioEntrevista;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OfertaEmpleoMapper.class, PerfilUsuarioMapper.class})
public interface HorarioEntrevistaMapper {

    @Mapping(source = "idHorario", target = "idHorario")
    @Mapping(source = "dia", target = "dia")
    @Mapping(source = "hora", target = "hora")
    @Mapping(source = "candidatosDisponibles", target = "candidatosDisponibles")
    @Mapping(source = "candidatosAsignados", target = "candidatosAsignados")
    @Mapping(source = "trabajadores", target = "trabajadores")

    HorarioEntrevistaDto toDto(HorarioEntrevista horarioEntrevista, @Context EvitarCiclosMapping contexto);
    HorarioEntrevista toEntity(HorarioEntrevistaDto horarioEntrevistaDto, @Context EvitarCiclosMapping contexto);
    List<HorarioEntrevistaDto> toDto(List<HorarioEntrevista> horarios, @Context EvitarCiclosMapping contexto);
}
