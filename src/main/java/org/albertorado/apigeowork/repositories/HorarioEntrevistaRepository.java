package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.HorarioEntrevista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HorarioEntrevistaRepository extends JpaRepository<HorarioEntrevista,Integer>, JpaSpecificationExecutor<HorarioEntrevista> {

    Optional<HorarioEntrevista> findByIdHorario(@Param("id") int idHorario);

    List<HorarioEntrevista> findAllByOfertaEmpleo_IdOfertaOrderByDiaAsc(@Param("idOferta") int idOferta);


}
