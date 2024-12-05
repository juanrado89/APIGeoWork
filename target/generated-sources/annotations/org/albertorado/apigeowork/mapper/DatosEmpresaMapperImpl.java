package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.DatosEmpresaDto;
import org.albertorado.apigeowork.dtos.SectorDto;
import org.albertorado.apigeowork.entities.DatosEmpresa;
import org.albertorado.apigeowork.entities.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-05T09:33:01+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class DatosEmpresaMapperImpl implements DatosEmpresaMapper {

    @Autowired
    private DireccionMapper direccionMapper;
    @Autowired
    private SectorMapper sectorMapper;

    @Override
    public DatosEmpresaDto toDto(DatosEmpresa entity) {
        if ( entity == null ) {
            return null;
        }

        DatosEmpresaDto datosEmpresaDto = new DatosEmpresaDto();

        datosEmpresaDto.setIdDatosEmpresa( entity.getIdDatosEmpresa() );
        datosEmpresaDto.setNombreEmpresa( entity.getNombreEmpresa() );
        datosEmpresaDto.setContactoNombre( entity.getContactoNombre() );
        datosEmpresaDto.setContactoEmail( entity.getContactoEmail() );
        datosEmpresaDto.setContactoTelefono( entity.getContactoTelefono() );
        datosEmpresaDto.setSitioWeb( entity.getSitioWeb() );
        datosEmpresaDto.setFechaRegistro( entity.getFechaRegistro() );
        datosEmpresaDto.setDireccion( direccionMapper.toDto( entity.getDireccion() ) );
        datosEmpresaDto.setSector( sectorMapper.toDto( entity.getSector() ) );

        return datosEmpresaDto;
    }

    @Override
    public DatosEmpresa toEntity(DatosEmpresaDto dto) {
        if ( dto == null ) {
            return null;
        }

        DatosEmpresa datosEmpresa = new DatosEmpresa();

        datosEmpresa.setIdDatosEmpresa( dto.getIdDatosEmpresa() );
        datosEmpresa.setNombreEmpresa( dto.getNombreEmpresa() );
        datosEmpresa.setSector( sectorDtoListToSectorList( dto.getSector() ) );
        datosEmpresa.setDireccion( direccionMapper.toEntity( dto.getDireccion() ) );
        datosEmpresa.setContactoNombre( dto.getContactoNombre() );
        datosEmpresa.setContactoEmail( dto.getContactoEmail() );
        datosEmpresa.setContactoTelefono( dto.getContactoTelefono() );
        datosEmpresa.setSitioWeb( dto.getSitioWeb() );
        datosEmpresa.setFechaRegistro( dto.getFechaRegistro() );

        return datosEmpresa;
    }

    protected List<Sector> sectorDtoListToSectorList(List<SectorDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Sector> list1 = new ArrayList<Sector>( list.size() );
        for ( SectorDto sectorDto : list ) {
            list1.add( sectorMapper.toEntity( sectorDto ) );
        }

        return list1;
    }
}
