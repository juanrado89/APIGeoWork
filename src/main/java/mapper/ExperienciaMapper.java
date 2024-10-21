package mapper;

import dtos.ExperienciaDto;
import entities.Experiencia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienciaMapper {
    ExperienciaDto toDto(Experiencia experiencia);
    Experiencia toEntity(ExperienciaDto experienciaDto);
}
