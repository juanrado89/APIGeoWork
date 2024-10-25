package repositories;

import dtos.DescripcionExperienciaDto;
import entities.DescripcionExperiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DescripcionExperienciaRepository extends JpaRepository<DescripcionExperiencia, Integer> {
    Optional<DescripcionExperienciaDto> findByIdDescripcionExperiencia(@Param("id") int id);
}
