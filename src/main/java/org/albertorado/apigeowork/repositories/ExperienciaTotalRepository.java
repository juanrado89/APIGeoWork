package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ExperienciaTotalRepository extends JpaRepository<ExperienciaTotal, Integer> {

    Optional<ExperienciaTotal> findById(@Param("id") int id);
}
