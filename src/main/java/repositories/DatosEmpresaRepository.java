package repositories;

import entities.DatosEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosEmpresaRepository extends JpaRepository<DatosEmpresa,Integer> {
}
