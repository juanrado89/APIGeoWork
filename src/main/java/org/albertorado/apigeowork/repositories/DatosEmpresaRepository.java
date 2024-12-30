package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.DatosEmpresa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DatosEmpresaRepository extends JpaRepository<DatosEmpresa,Integer> {

    Optional<DatosEmpresa> findDatosEmpresaByIdDatosEmpresa(@Param("id") int idDatosEmpresa);

    @Modifying
    @Transactional
    int deleteByIdDatosEmpresa(@Param("id") int idDatosEmpresa);
}
