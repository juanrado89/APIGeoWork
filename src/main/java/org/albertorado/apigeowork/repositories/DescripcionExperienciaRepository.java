package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.dtos.DescripcionExperienciaDto;
import org.albertorado.apigeowork.entities.DescripcionExperiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DescripcionExperienciaRepository extends JpaRepository<DescripcionExperiencia, Integer> {
    Optional<DescripcionExperienciaDto> findByIdDescripcionExperiencia(@Param("id") int id);
}
