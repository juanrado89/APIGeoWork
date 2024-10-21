package mapper;

import dtos.HorarioEntrevistaDto;
import entities.HorarioEntrevista;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HorarioEntrevistaMapper {
    HorarioEntrevistaDto toDto(HorarioEntrevista horarioEntrevista);
    HorarioEntrevista toEntity(HorarioEntrevistaDto horarioEntrevistaDto);
    List<HorarioEntrevistaDto> toDto(List<HorarioEntrevista> horarios);
}
