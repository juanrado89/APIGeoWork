package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.dtos.EstadoDto;
import org.albertorado.apigeowork.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado,Integer> {

    Optional<EstadoDto> findByIdEstado(@Param("id") int idEstado);
    Optional<EstadoDto> findByEstadoContainsIgnoreCase(@Param("estado") String estado);
}
