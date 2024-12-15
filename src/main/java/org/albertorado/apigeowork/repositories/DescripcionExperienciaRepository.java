package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.DescripcionExperiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DescripcionExperienciaRepository extends JpaRepository<DescripcionExperiencia, Integer> {
    List<DescripcionExperiencia> findAllByExperienciaTotal_IdExperienciaTotal(@Param("id") int id);
    Optional<DescripcionExperiencia> findByIdDescripcionExperiencia(@Param("id") int id);
}
