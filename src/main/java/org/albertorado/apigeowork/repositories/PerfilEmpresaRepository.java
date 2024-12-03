package org.albertorado.apigeowork.repositories;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PerfilEmpresaRepository extends JpaRepository<PerfilEmpresa, Integer> {


    Optional<PerfilEmpresa> findByIdUsuario(@Param("id") int idUsuario);

    Optional<PerfilEmpresa> findByEmailContainsIgnoreCase(@Param("email") String email);

    Optional<PerfilEmpresa> findPerfilEmpresaByEmailContainingIgnoreCase(@Param("email") String email);

    @Query("SELECT d.email,d.idUsuario,d.password,d.foto,d.empresa FROM PerfilEmpresa d WHERE d.email like lower(:mail) ")
    PerfilEmpresa buscarPorMail(@Param("mail") String mail);

    @Query("SELECT d.email,d.idUsuario,d.password FROM PerfilEmpresa d WHERE d.email like :mail ")
    Optional<PerfilEmpresa> buscarPorMailAutenticacion(@Param("mail") String mail);


    int deletePerfilEmpresaByIdUsuario(@Param("id") int id);

    Optional<PerfilEmpresa> findPerfilEmpresaByEmailContains(@Size(min = 20, max = 255) @Email @NotNull String email);

    Optional<PerfilEmpresa> findPerfilEmpresaByEmail(@Size(min = 20, max = 255) @Email @NotNull String email);
}
