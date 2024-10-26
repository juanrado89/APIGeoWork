package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.ExperienciaDto;
import org.albertorado.apigeowork.entities.Experiencia;
import org.albertorado.apigeowork.mapper.ExperienciaMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.ExperienciaRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ExperienciaService {
    private final ExperienciaRepository experienciaRepository;
    private final ExperienciaMapper experienciaMapper;

    public ExperienciaService(ExperienciaRepository experienciaRepository, ExperienciaMapper experienciaMapper) {
        this.experienciaRepository = experienciaRepository;
        this.experienciaMapper = experienciaMapper;
    }

    public ExperienciaDto buscarExperienciaPorId(int id) {
        Optional<ExperienciaDto> resultado = experienciaRepository.findByIdExperiencia(id);
        return resultado.orElseGet(null);
    }

    public ExperienciaDto crearExperiencia(Experiencia experiencia) {
        Experiencia creada = experienciaRepository.save(experiencia);
        return experienciaMapper.toDto(creada);
    }

    public ExperienciaDto actualizarExperiencia(int id, Experiencia experiencia) {
        Optional<ExperienciaDto> busqueda = experienciaRepository.findByIdExperiencia(id);
        if(busqueda.isPresent()){
            Experiencia actualizada = experienciaRepository.save(experiencia);
            return experienciaMapper.toDto(actualizada);
        }else{
            return null;
        }
    }

    public void borrarExperiencia(int id) {
        experienciaRepository.deleteByIdExperiencia(id);
    }

    public List<ExperienciaDto> buscarExperienciaPorSector(String sector) {
        return experienciaRepository.findAllBySectorContainsIgnoreCase(sector);
    }
}
