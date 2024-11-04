package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado,Integer> {

    Optional<Estado> findByIdEstado(@Param("id") int idEstado);
    Optional<Estado> findByEstadoContainsIgnoreCase(@Param("estado") String estado);
}
