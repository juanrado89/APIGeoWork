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

    Optional<PerfilEmpresa> findPerfilEmpresaByEmailContainingIgnoreCase(@Param("email") String email);

    int deletePerfilEmpresaByIdUsuario(@Param("id") int id);

    Optional<PerfilEmpresa> findPerfilEmpresaByEmail(@Size(min = 20, max = 255) @Email @NotNull String email);
}
