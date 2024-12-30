package org.albertorado.apigeowork.repositories;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario,Integer> {

    Optional<PerfilUsuario> findByIdPerfil(@Param("id") int idUsuario);
    Optional<PerfilUsuario> findByEmailContainsIgnoreCase(@Param("email") String email);
    @Query("SELECT p FROM PerfilUsuario p JOIN p.horarios h WHERE h.idHorario = :id")
    List<PerfilUsuario> findAllByHorarioId(@Param("id") Integer idHorario);
    @Query("SELECT p FROM PerfilUsuario p JOIN p.ofertas h WHERE h.idOferta = :id")
    List<PerfilUsuario> findAllByOfertaId(@Param("id") Integer idHorario);
    int deleteByIdPerfil(@Param("id") int idPerfil);
    Optional<PerfilUsuario> findPerfilUsuarioByEmail(@Size(min = 20, max = 255) @Email @NotNull String email);
}
