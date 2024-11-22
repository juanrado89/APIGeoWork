package org.albertorado.apigeowork.services;

import jakarta.transaction.Transactional;
import org.albertorado.apigeowork.dtos.ExperienciaDto;
import org.albertorado.apigeowork.entities.Experiencia;
import org.albertorado.apigeowork.entities.Sector;
import org.albertorado.apigeowork.mapper.ExperienciaMapper;
import org.albertorado.apigeowork.repositories.SectorRepository;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.ExperienciaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaService {
    private final ExperienciaRepository experienciaRepository;
    private final ExperienciaMapper experienciaMapper;
    private final SectorRepository sectorRepository;

    public ExperienciaService(ExperienciaRepository experienciaRepository, ExperienciaMapper experienciaMapper, SectorRepository sectorRepository) {
        this.experienciaRepository = experienciaRepository;
        this.experienciaMapper = experienciaMapper;
        this.sectorRepository = sectorRepository;
    }

    public ExperienciaDto buscarExperienciaPorId(int id) {
        Optional<Experiencia> resultado = experienciaRepository.findByIdExperiencia(id);
        if(resultado.isEmpty()){
            return null;
        }
        return experienciaMapper.toDto(resultado.get());
    }

    public ExperienciaDto crearExperiencia(Experiencia experiencia) {
        List<Sector> sectoresAniadir = new ArrayList<>();
        for(Sector sector :experiencia.getSector()){
            sectoresAniadir.add(sectorRepository.findSectorByIdSector(sector.getIdSector()).get());
        }
        experiencia.setSector(sectoresAniadir);
        Experiencia creada = experienciaRepository.save(experiencia);
        return experienciaMapper.toDto(creada);
    }

    @Transactional
    public ExperienciaDto actualizarExperiencia(int id, Experiencia experiencia) {
        Optional<Experiencia> busqueda = experienciaRepository.findByIdExperiencia(id);

        if (busqueda.isPresent()) {
            Experiencia experienciaExistente = busqueda.get();

            experienciaExistente.setNivelEducativo(experiencia.getNivelEducativo());
            if (experiencia.getExperienciaTotal() != null) {
                experienciaExistente.setExperienciaTotal(experiencia.getExperienciaTotal());
            }
            if (experiencia.getCvUrl() != null) {
                experienciaExistente.setCvUrl(experiencia.getCvUrl());
            }

            experienciaExistente.setFechaRegistro(experiencia.getFechaRegistro());

            if(!experiencia.getSector().isEmpty()){
                List<Sector> sectores = new ArrayList<>();
                for(Sector sector : experiencia.getSector()){
                    sectores.add(sector);
                }
                experienciaExistente.setSector(sectores);
            }
            Experiencia actualizada = experienciaRepository.save(experienciaExistente);
            return experienciaMapper.toDto(actualizada);
        } else {
            return null;
        }
    }

    public void borrarExperiencia(int id) {
        experienciaRepository.deleteByIdExperiencia(id);
    }

    public List<ExperienciaDto> buscarExperienciaPorSector(String sector) {
        return experienciaMapper.toDto(experienciaRepository.findAllBySector_SectorContainsIgnoreCase(sector));
    }
}
