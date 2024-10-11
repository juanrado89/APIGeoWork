package repositories;

import dtos.EmpresaDto;
import entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {

    Optional<EmpresaDto> findByIdEmpresa(@Param("id") int idEmpresa);

    int deleteByIdEmpresa(@Param("id") int idEmpresa);
}
