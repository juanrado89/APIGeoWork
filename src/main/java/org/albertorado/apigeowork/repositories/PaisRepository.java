package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.dtos.PaisDto;
import org.albertorado.apigeowork.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais,Integer> {

    Optional<PaisDto> findAllByIdPais(@Param("pais") int idPais);
    Optional<PaisDto> findAllByPaisContainsIgnoreCase(@Param("pais") String pais);

}
