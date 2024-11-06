package org.albertorado.apigeowork.mapper;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.FotoDto;
import org.albertorado.apigeowork.entities.Foto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T21:49:39+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
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
        byte[] datos = foto.getDatos();
        if ( datos != null ) {
            fotoDto.setDatos( Arrays.copyOf( datos, datos.length ) );
        }

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
        byte[] datos = fotoDto.getDatos();
        if ( datos != null ) {
            foto.setDatos( Arrays.copyOf( datos, datos.length ) );
        }

        return foto;
    }
}
