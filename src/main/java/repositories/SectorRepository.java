package repositories;

import dtos.SectorDto;
import entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SectorRepository extends JpaRepository<Sector, Integer> {
    Optional<SectorDto> findSectorByIdSector(@Param("id") int id);
    Optional<SectorDto> findSectorBySectorContainingIgnoreCase(@Param("sector") String sector);
}
