package org.albertorado.apigeowork.repositories;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario,Integer> {

    Optional<PerfilUsuario> findByIdPerfil(@Param("id") int idUsuario);

    Optional<PerfilUsuario> findByEmailContainsIgnoreCase(@Param("email") String email);

    @Query("SELECT d.email,d.idPerfil,d.password,d.trabajador,d.foto FROM PerfilUsuario d WHERE d.email like lower(:email) ")
    Optional<PerfilUsuario> buscarPorMail(@Param("email") String email);

    @Query("SELECT d.email,d.idPerfil,d.password FROM PerfilUsuario d WHERE d.email like lower(:email) ")
    Optional<PerfilUsuario> buscarPorMailAutenticacion(@Param("email") String email);

    int deleteByIdPerfil(@Param("id") int idPerfil);

    Optional<PerfilUsuario> findPerfilUsuariosByEmailContainsIgnoreCase(@Size(min = 20, max = 255) @Email @NotNull String email);
}
