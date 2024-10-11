package repositories;

import dtos.DireccionDto;
import entities.Direccion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DireccionReposirory extends JpaRepository<Direccion,Integer> {

    Optional<DireccionDto> findDireccionByIdDireccion(@Param("direccion") int idDireccion);

    @Modifying
    @Transactional
    int deleteDireccionByIdDireccion(@Param("direccion") int idDireccion);
}
