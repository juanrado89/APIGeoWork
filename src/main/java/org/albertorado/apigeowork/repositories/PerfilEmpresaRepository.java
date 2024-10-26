package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.dtos.PerfilEmpresaDto;
import org.albertorado.apigeowork.dtos.PerfilEmpresaPDto;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PerfilEmpresaRepository extends JpaRepository<PerfilEmpresa, Integer> {

    Optional<PerfilEmpresaDto> findByIdUsuario(@Param("id") int idUsuario);

    Optional<PerfilEmpresaPDto> findByEmailContainsIgnoreCase(@Param("email") String email);

    Optional<PerfilEmpresaDto> findPerfilEmpresaByEmailContainingIgnoreCase(@Param("email") String email);

    int updatePerfilUsuarioByIdPerfilIs(@Param("id") int id,@Param("perfil") PerfilEmpresa perfil);

    int deletePerfilEmpresaByIdEmpresa(@Param("id") int id);
}
