package mapper;

import dtos.NivelEducativoDto;
import entities.NivelEducativo;

public interface NivelEducativoMapper {

    NivelEducativoDto toDto(NivelEducativo nivelEducativo);
    NivelEducativo toEntity(NivelEducativoDto nivelEducativoDto);
}
