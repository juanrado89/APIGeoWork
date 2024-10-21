package mapper;


import dtos.OfertaEmpleoDto;
import entities.OfertaEmpleo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfertaEmpleoMapper {
    OfertaEmpleoDto toDto(OfertaEmpleo ofertaEmpleo);
    OfertaEmpleo toEntity(OfertaEmpleoDto ofertaEmpleoDto);

    List<OfertaEmpleoDto> toDto(List<OfertaEmpleo> ofertas);
}
