package repositories;

import dtos.HorarioEntrevistaDto;
import entities.HorarioEntrevista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HorarioEntrevistaRepository extends JpaRepository<HorarioEntrevista,Integer> {

    Optional<HorarioEntrevistaDto> findByIdHorario(@Param("id") int idHorario);

    Optional<HorarioEntrevistaDto> findByOfertaEmpleo_IdOferta(@Param("idOferta") int idOferta);


}
