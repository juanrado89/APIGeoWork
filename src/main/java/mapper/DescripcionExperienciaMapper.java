package mapper;

import dtos.DescripcionExperienciaDto;
import entities.DescripcionExperiencia;

public interface DescripcionExperienciaMapper {

    DescripcionExperienciaDto toDto(DescripcionExperiencia descripcionExperiencia);
    DescripcionExperiencia toEntity(DescripcionExperienciaDto descripcionExperienciaDto);

}
