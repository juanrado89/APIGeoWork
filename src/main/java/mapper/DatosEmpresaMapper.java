package mapper;

import dtos.DatosEmpresaDto;
import entities.DatosEmpresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DatosEmpresaMapper {
    DatosEmpresaDto toDto(DatosEmpresa entity);
    DatosEmpresa toEntity(DatosEmpresaDto dto);
}
