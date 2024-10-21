package repositories;

import dtos.HorarioEntrevistaDto;
import entities.HorarioEntrevista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HorarioEntrevistaRepository extends JpaRepository<HorarioEntrevista,Integer>, JpaSpecificationExecutor<HorarioEntrevista> {

    Optional<HorarioEntrevistaDto> findByIdHorario(@Param("id") int idHorario);

    List<HorarioEntrevistaDto> findAllByOfertaEmpleo_IdOferta(@Param("idOferta") int idOferta);


}
