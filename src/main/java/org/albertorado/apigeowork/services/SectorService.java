package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.SectorDto;
import org.albertorado.apigeowork.entities.Sector;
import org.albertorado.apigeowork.mapper.SectorMapper;
import org.albertorado.apigeowork.repositories.SectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;
    private final SectorMapper sectorMapper;

    public SectorService(SectorRepository sectorRepository, SectorMapper sectorMapper) {
        this.sectorRepository = sectorRepository;
        this.sectorMapper = sectorMapper;
    }

    public SectorDto buscarPorId(int id) {

        Optional<Sector> resultado = sectorRepository.findSectorByIdSector(id);
        if(resultado.isEmpty()){
            return null;
        }
        return sectorMapper.toDto(resultado.get());

    }

    public SectorDto buscarPorNombre(String sector) {

        Optional<Sector> reusltado = sectorRepository.findSectorBySectorContainingIgnoreCase(sector);
        if(reusltado.isEmpty()){
            return null;
        }
        return sectorMapper.toDto(reusltado.get());

    }

    public List<SectorDto> buscarTodos() {
        List<Sector> resultado = sectorRepository.findAll();
        return sectorMapper.toDto(resultado);
    }
}
