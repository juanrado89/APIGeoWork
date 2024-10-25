package repositories;

import dtos.NivelDto;
import entities.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NivelRepository extends JpaRepository<Nivel, Integer> {

    Optional<NivelDto> findNivelByIdNivel(@Param("id") int id);
    Optional<NivelDto> findNivelByNombreNivelContainingIgnoreCase(@Param("nombre") String nombre);
}
