package repositories;

import dtos.OfertaEmpleoDto;
import entities.OfertaEmpleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OfertaEmpleoRepository extends JpaRepository<OfertaEmpleo,Integer> {
    Optional<OfertaEmpleoDto> findByIdOferta(@Param("id") int idOferta);

    List<OfertaEmpleoDto> findAllByTituloContainsIgnoreCase(@Param("titulo") String titulo);
    List<OfertaEmpleoDto> findAllByNivelEducativoRequeridoContainsIgnoreCase(@Param("nivelEducativo") String nivelEducativo);
    List<OfertaEmpleoDto> findAllByPais_PaisAndCiudadContainingIgnoreCaseAndNivelEducativoRequeridoIsContainingIgnoreCaseO
}
