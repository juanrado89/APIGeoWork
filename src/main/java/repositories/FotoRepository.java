package repositories;

import dtos.FotoDto;
import entities.Foto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FotoRepository extends JpaRepository<Foto,Integer> {

    Optional<FotoDto> findAllByIdFoto(@Param("foto") int idFoto);
    Optional<FotoDto> findAllByNombreLikeIgnoreCase(@Param("foto") String nombre);
    @Modifying
    @Transactional
    int deleteFotoByIdFoto(@Param("foto") int idFoto);
}
