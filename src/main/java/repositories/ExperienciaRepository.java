package repositories;

import dtos.ExperienciaDto;
import entities.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExperienciaRepository extends JpaRepository<Experiencia,Integer> {

    Optional<ExperienciaDto> findByIdExperiencia(@Param("id") int idExperiencia);

    List<ExperienciaDto> findAllBySectorContainsIgnoreCase(@Param("sector") String sector);
    int deleteByIdExperiencia(@Param("id") int idExperiencia);
}
