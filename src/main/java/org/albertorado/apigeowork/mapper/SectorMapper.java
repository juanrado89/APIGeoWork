package org.albertorado.apigeowork.mapper;

import org.albertorado.apigeowork.dtos.EstadoDto;
import org.albertorado.apigeowork.dtos.SectorDto;
import org.albertorado.apigeowork.entities.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectorMapper {

    @Mapping(source = "idSector", target = "idSector")
    @Mapping(source = "sector", target = "sector")
    SectorDto toDto(Sector sector);
    Sector toEntity(SectorDto sectorDto);
    List<SectorDto> toDto(List<Sector> resultado);
}
