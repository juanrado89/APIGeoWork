package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {

    Optional<Ciudad> findByIdCiudad(@Param("id") int idCiudad);

    Optional<Ciudad> findByCiudadContainsIgnoreCase(@Param("ciudad") String ciudad);

}
