package mapper;

import dtos.TrabajadorDto;
import entities.Trabajador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrabajadorMapper {

    TrabajadorDto toDto(Trabajador trabajador);
    Trabajador toEntity(TrabajadorDto trabajadorDto);
}
