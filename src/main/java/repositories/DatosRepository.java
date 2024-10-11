package repositories;

import dtos.DatosDto;
import entities.Datos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DatosRepository extends JpaRepository<Datos,Integer> {

    Optional<DatosDto> findDatosByIdDatos(@Param("datos") int idDatos);
    Optional<DatosDto> findDatosByNombreContainsIgnoreCaseAndApellidosContainsIgnoreCase(@Param("nombre") String nombre,@Param("apellidos") String apellidos);
    Optional<DatosDto> findDatosByE
    @Modifying
    @Transactional
    int deleteByIdDatos(@Param("datos") int idDatos);
}
