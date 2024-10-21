package mapper;

import dtos.HorarioEntrevistaDto;
import entities.HorarioEntrevista;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HorarioEntrevistaMapper {
    HorarioEntrevistaDto toDto(HorarioEntrevista horarioEntrevista);
    HorarioEntrevista toEntity(HorarioEntrevistaDto horarioEntrevistaDto);
}
