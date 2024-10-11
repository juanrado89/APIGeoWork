package repositories;

import dtos.PerfilEmpresaDto;
import dtos.PerfilEmpresaPDto;
import entities.PerfilEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PerfilEmpresaRepository extends JpaRepository<PerfilEmpresa, Integer> {

    Optional<PerfilEmpresaDto> findByIdUsuario(@Param("id") int idUsuario);

    Optional<PerfilEmpresaPDto> findByEmailContainsIgnoreCase(@Param("email") String email);

    int deleteByIdUsuario(@Param("id") int idUsuario);
}
