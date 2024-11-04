package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.Documento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DocumentoRepository extends JpaRepository<Documento,Integer> {

    Optional<Documento> findByIdDocumento(@Param("documento") int idDocumento);

    @Modifying
    @Transactional
    int deleteDocumentoByIdDocumento(@Param("documento") int idDocumento);
}
