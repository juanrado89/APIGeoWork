package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.HorarioEntrevistaDto;
import org.albertorado.apigeowork.entities.HorarioEntrevista;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HorarioEntrevistaMapper {
    HorarioEntrevistaDto toDto(HorarioEntrevista horarioEntrevista);
    HorarioEntrevista toEntity(HorarioEntrevistaDto horarioEntrevistaDto);
    List<HorarioEntrevistaDto> toDto(List<HorarioEntrevista> horarios);
}
