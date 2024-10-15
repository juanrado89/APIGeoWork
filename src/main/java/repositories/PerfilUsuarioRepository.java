package repositories;

import dtos.PerfilUsuarioDto;
import dtos.PerfilUsuarioPDto;
import entities.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario,Integer> {

    Optional<PerfilUsuarioDto> findByIdUsuario(@Param("id") int idUsuario);

    Optional<PerfilUsuarioPDto> findByEmailContainsIgnoreCase(@Param("email") String email);

    Optional<PerfilUsuarioDto> findPerfilUsuarioByEmailContainsIgnoreCase(@Param("email") String email);

    int deleteByIdUsuario(@Param("id") int idUsuario);

    int updatePerfilUsuarioByIdPerfilIs(@Param("id") int idPerfil, @Param("perfil") PerfilUsuario idUsuario);
}
