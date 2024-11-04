package org.albertorado.apigeowork.repositories;

import org.albertorado.apigeowork.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SectorRepository extends JpaRepository<Sector, Integer> {
    Optional<Sector> findSectorByIdSector(@Param("id") int id);
    Optional<Sector> findSectorBySectorContainingIgnoreCase(@Param("sector") String sector);
}
