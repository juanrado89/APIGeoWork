package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NivelRepository extends JpaRepository<Nivel, Integer> {

    Optional<Nivel> findNivelByIdNivel(@Param("id") int id);
    Optional<Nivel> findNivelByNombreNivelContainingIgnoreCase(@Param("nombre") String nombre);
}
