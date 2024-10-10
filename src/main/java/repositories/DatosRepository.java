package repositories;

import entities.Datos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosRepository extends JpaRepository<Datos,Integer> {

}
