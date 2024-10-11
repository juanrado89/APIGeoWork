package repositories;

import dtos.DocumentoDto;
import entities.Documento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DocumentoRepository extends JpaRepository<Documento,Integer> {

    Optional<DocumentoDto> findAllByIdDocumento(@Param("documento") int idDocumento);
    Optional<DocumentoDto> findAllByNombreLikeIgnoreCase(@Param("documento") String nombre);
    @Modifying
    @Transactional
    int deleteDocumentoByIdDocumento(@Param("documento") int idDocumento);
}
