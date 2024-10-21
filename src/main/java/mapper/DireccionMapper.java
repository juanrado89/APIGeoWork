package mapper;

import dtos.DireccionDto;
import entities.Direccion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DireccionMapper {
    DireccionDto toDto(Direccion direccion);
    Direccion toEntity(DireccionDto direccionDto);
}
