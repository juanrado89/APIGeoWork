package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.Datos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DatosRepository extends JpaRepository<Datos,Integer> {

    Optional<Datos> findDatosByIdDatos(@Param("datos") int idDatos);

    @Modifying
    @Transactional
    int deleteByIdDatos(@Param("datos") int idDatos);
}
