package repositories;

import dtos.OfertaEmpleoDto;
import entities.OfertaEmpleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OfertaEmpleoRepository extends JpaRepository<OfertaEmpleo,Integer>, JpaSpecificationExecutor<OfertaEmpleo> {
    Optional<OfertaEmpleoDto> findByIdOferta(@Param("id") int idOferta);

}
