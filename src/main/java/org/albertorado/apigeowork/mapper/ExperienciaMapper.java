package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.ExperienciaDto;
import org.albertorado.apigeowork.entities.Experiencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {NivelEducativoMapper.class,ExperienciaMapper.class, DocumentoMapper.class, SectorMapper.class})
public interface ExperienciaMapper {

    @Mapping(source = "idExperiencia", target = "idExperiencia")
    @Mapping(source = "nivelEducativo", target = "nivelEducativo")
    @Mapping(source = "sector", target = "sector")
    @Mapping(source = "experienciaTotal", target = "experienciaTotal")
    @Mapping(source = "cvUrl", target = "cvUrl")
    @Mapping(source = "fechaRegistro", target = "fechaRegistro")

    ExperienciaDto toDto(Experiencia experiencia);
    Experiencia toEntity(ExperienciaDto experienciaDto);

    List<ExperienciaDto> toDto(List<Experiencia> allBySectorSectorContainsIgnoreCase);
}
