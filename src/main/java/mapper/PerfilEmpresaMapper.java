package mapper;

import dtos.PerfilEmpresaDto;
import entities.PerfilEmpresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PerfilEmpresaMapper {
    PerfilEmpresaDto toDto(PerfilEmpresa perfilEmpresa);
    PerfilEmpresa toEntity(PerfilEmpresaDto perfilEmpresaPDto);
}
