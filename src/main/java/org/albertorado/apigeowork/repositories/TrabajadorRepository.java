package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.Trabajador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TrabajadorRepository extends JpaRepository<Trabajador,Integer> {

    Optional<Trabajador> findTrabajadorByIdTrabajador(@Param("trabajador") int idTrabajador);

    @Modifying
    @Transactional
    int deleteByIdTrabajador(@Param("trabajador") int idTrabajador);
}
