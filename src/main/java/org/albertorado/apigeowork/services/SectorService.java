package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.SectorDto;
import org.albertorado.apigeowork.repositories.SectorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
