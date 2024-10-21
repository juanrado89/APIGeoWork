package mapper;

import dtos.DocumentoDto;
import entities.Documento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {
    DocumentoDto toDto(Documento documento);
    Documento toEntity(DocumentoDto documentoDto);
}
