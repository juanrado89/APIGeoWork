package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.Direccion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DireccionReposirory extends JpaRepository<Direccion,Integer> {

    Optional<Direccion> findDireccionByIdDireccion(@Param("direccion") int idDireccion);


    @Modifying
    @Transactional
    int deleteDireccionByIdDireccion(@Param("direccion") int idDireccion);
}
