package mapper;

import dtos.DatosDto;
import entities.Datos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DatosMapper {
    DatosDto toDto(Datos datos);
    DatosDto toEntity(DatosDto dto);
}
