package repositories;

import dtos.CiudadDto;
import entities.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {

    Optional<CiudadDto> findByIdCiudad(@Param("id") int idCiudad);

    Optional<CiudadDto> findByCiudadContainsIgnoreCase(@Param("ciudad") String ciudad);

}
