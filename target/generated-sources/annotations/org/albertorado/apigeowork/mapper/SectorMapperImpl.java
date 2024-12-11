package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.SectorDto;
import org.albertorado.apigeowork.entities.Sector;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-11T19:14:53+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class SectorMapperImpl implements SectorMapper {

    @Override
    public SectorDto toDto(Sector sector) {
        if ( sector == null ) {
            return null;
        }

        SectorDto sectorDto = new SectorDto();

        sectorDto.setIdSector( sector.getIdSector() );
        sectorDto.setSector( sector.getSector() );

        return sectorDto;
    }

    @Override
    public Sector toEntity(SectorDto sectorDto) {
        if ( sectorDto == null ) {
            return null;
        }

        Sector sector = new Sector();

        sector.setIdSector( sectorDto.getIdSector() );
        sector.setSector( sectorDto.getSector() );

        return sector;
    }

    @Override
    public List<SectorDto> toDto(List<Sector> resultado) {
        if ( resultado == null ) {
            return null;
        }

        List<SectorDto> list = new ArrayList<SectorDto>( resultado.size() );
        for ( Sector sector : resultado ) {
            list.add( toDto( sector ) );
        }

        return list;
    }
}
