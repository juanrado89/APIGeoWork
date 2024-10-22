package repositories;

import dtos.ExperienciaTotalDto;
import entities.ExperienciaTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ExperienciaTotalRepository extends JpaRepository<ExperienciaTotal, Integer> {

    Optional<ExperienciaTotalDto> findById(@Param("id") int id);
}
