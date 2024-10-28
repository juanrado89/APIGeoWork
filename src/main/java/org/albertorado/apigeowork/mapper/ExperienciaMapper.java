package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.ExperienciaDto;
import org.albertorado.apigeowork.entities.Experiencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {NivelEducativoMapper.class,ExperienciaMapper.class, DocumentoMapper.class})
public interface ExperienciaMapper {

    @Mapping(source = "idExperiencia", target = "idExperiencia")
    @Mapping(source = "nivelEducativo", target = "nivelEducativoDto")
    @Mapping(source = "sector", target = "sectorDto")
    @Mapping(source = "experienciaTotal", target = "experienciaTotalDto")
    @Mapping(source = "documento", target = "documentoDto")
    @Mapping(source = "fechaRegistro", target = "fechaRegistro")

    ExperienciaDto toDto(Experiencia experiencia);
    Experiencia toEntity(ExperienciaDto experienciaDto);
}
