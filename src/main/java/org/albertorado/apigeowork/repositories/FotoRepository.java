package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.dtos.FotoDto;
import org.albertorado.apigeowork.entities.Foto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface FotoRepository extends JpaRepository<Foto,Integer> {

    Optional<FotoDto> findByIdFoto(@Param("foto") int idFoto);
    @Modifying
    @Transactional
    int deleteFotoByIdFoto(@Param("foto") int idFoto);
}
