package mapper;

import dtos.PerfilUsuarioDto;
import entities.PerfilUsuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PerfilUsuarioMapper {
    PerfilUsuarioDto toDto(PerfilUsuario perfilUsuario);
    PerfilUsuario toEntity(PerfilUsuarioDto perfilUsuarioDto);
}
