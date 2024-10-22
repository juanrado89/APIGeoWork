package repositories;

import dtos.NivelEducativoDto;
import entities.NivelEducativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NivelEducativoRepository extends JpaRepository<NivelEducativo, Integer> {


    Optional<NivelEducativoDto> findById(@Param("id") int id);
    List<NivelEducativoDto> findByTitulo(@Param("titulo") String titulo);
}
