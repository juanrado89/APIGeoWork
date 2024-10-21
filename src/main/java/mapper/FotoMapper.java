package mapper;

import dtos.FotoDto;
import entities.Foto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FotoMapper {
    FotoDto ToDto(Foto foto);
    Foto ToEntity(FotoDto fotoDto);
}
