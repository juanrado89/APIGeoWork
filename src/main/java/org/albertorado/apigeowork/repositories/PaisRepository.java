package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais,Integer> {

    Optional<Pais> findAllByIdPais(@Param("pais") int idPais);
    Optional<Pais> findAllByPaisContainsIgnoreCase(@Param("pais") String pais);

}
