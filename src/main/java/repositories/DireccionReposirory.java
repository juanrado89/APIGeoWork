package repositories;

import entities.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionReposirory extends JpaRepository<Direccion,Integer> {
}
