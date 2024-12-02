package org.albertorado.apigeowork.mapper;

import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.FotoDto;
import org.albertorado.apigeowork.entities.Foto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-02T11:22:00+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class FotoMapperImpl implements FotoMapper {

    @Override
    public FotoDto toDto(Foto foto) {
        if ( foto == null ) {
            return null;
        }

        FotoDto fotoDto = new FotoDto();

        fotoDto.setIdFoto( foto.getIdFoto() );
        fotoDto.setNombre( foto.getNombre() );
        fotoDto.setTipoContenido( foto.getTipoContenido() );
        fotoDto.setDatos( foto.getDatos() );

        return fotoDto;
    }

    @Override
    public Foto toEntity(FotoDto fotoDto) {
        if ( fotoDto == null ) {
            return null;
        }

        Foto foto = new Foto();

        foto.setIdFoto( fotoDto.getIdFoto() );
        foto.setNombre( fotoDto.getNombre() );
        foto.setTipoContenido( fotoDto.getTipoContenido() );
        foto.setDatos( fotoDto.getDatos() );

        return foto;
    }
}
