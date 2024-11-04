package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.NivelEducativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NivelEducativoRepository extends JpaRepository<NivelEducativo, Integer> {


    Optional<NivelEducativo> findById(@Param("id") int id);
    List<NivelEducativo> findAllByTituloNivelEducativoContainingIgnoreCase(@Param("titulo") String titulo);
}
