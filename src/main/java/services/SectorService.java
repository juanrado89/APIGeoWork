package services;

import dtos.SectorDto;
import repositories.SectorRepository;

import java.util.Optional;

public class SectorService {

    private final SectorRepository sectorRepository;

    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public SectorDto buscarPorId(int id) {

        Optional<SectorDto> resultado = sectorRepository.findSectorByIdSector(id);
        return resultado.orElse(null);

    }

    public SectorDto buscarPorNombre(String sector) {

        Optional<SectorDto> reusltado = sectorRepository.findSectorBySectorContainingIgnoreCase(sector);
        return reusltado.orElse(null);

    }
}
