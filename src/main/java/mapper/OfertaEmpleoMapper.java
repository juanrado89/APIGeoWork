package mapper;


import dtos.OfertaEmpleoDto;
import entities.OfertaEmpleo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfertaEmpleoMapper {
    OfertaEmpleoDto toDto(OfertaEmpleo ofertaEmpleo);
    OfertaEmpleo toEntity(OfertaEmpleoDto ofertaEmpleoDto);
}
