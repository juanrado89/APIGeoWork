package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.dtos.ExperienciaDto;
import org.albertorado.apigeowork.entities.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExperienciaRepository extends JpaRepository<Experiencia,Integer> {

    Optional<Experiencia> findByIdExperiencia(@Param("id") int idExperiencia);

    List<ExperienciaDto> findAllBySector_SectorContainsIgnoreCase(@Param("sector") String sector);
    int deleteByIdExperiencia(@Param("id") int idExperiencia);
}
