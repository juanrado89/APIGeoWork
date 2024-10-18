package repositories;

import dtos.TrabajadorDto;
import entities.Trabajador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TrabajadorRepository extends JpaRepository<Trabajador,Integer> {

    Optional<TrabajadorDto> findTrabajadorByIdTrabajador(@Param("trabajador") int idTrabajador);

    Optional<TrabajadorDto> findTrabajadorByDatosUsuario_IdDatos(@Param("idDatos") int idDatos);


    @Modifying
    @Transactional
    int deleteByIdTrabajador(@Param("trabajador") int idTrabajador);
}
