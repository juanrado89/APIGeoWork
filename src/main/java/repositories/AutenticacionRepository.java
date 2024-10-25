package repositories;

import entities.Autenticacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AutenticacionRepository extends JpaRepository<Autenticacion, Integer> {

    Optional<Autenticacion> findByRefreshToken(@Param("token")String token);
    Optional<Autenticacion> findByIdUsuarioAndTipoUsuario(@Param("id") int idUsuario, @Param("tipoPerfil") String tipoPerfil);
}
