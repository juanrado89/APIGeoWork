package mapper;

import dtos.EmpresaDto;
import entities.Empresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {
    EmpresaDto toDto(Empresa empresa);
    Empresa toEmntity(EmpresaDto empresaDto);
}
