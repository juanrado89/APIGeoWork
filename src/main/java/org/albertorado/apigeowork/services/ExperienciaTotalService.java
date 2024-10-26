package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.albertorado.apigeowork.mapper.ExperienciaTotalMapper;
import org.albertorado.apigeowork.repositories.ExperienciaTotalRepository;

import java.util.Optional;

public class ExperienciaTotalService {

    private final ExperienciaTotalRepository experienciaTotalRepository;
    private final ExperienciaTotalMapper experienciaTotalMapper;

    public ExperienciaTotalService(ExperienciaTotalRepository experienciaTotalRepository, ExperienciaTotalMapper experienciaTotalMapper) {
        this.experienciaTotalRepository = experienciaTotalRepository;
        this.experienciaTotalMapper = experienciaTotalMapper;
    }

    public ExperienciaTotalDto buscarPorId(int id) {
        Optional<ExperienciaTotalDto> resultado = experienciaTotalRepository.findById(id);
        return resultado.orElse(null);
    }

    public ExperienciaTotalDto crearExperiencia(ExperienciaTotal experienciaTotal) {
        ExperienciaTotal creada = experienciaTotalRepository.save(experienciaTotal);
        return experienciaTotalMapper.toDto(creada);
    }

    public ExperienciaTotalDto actualizarExperiencia(int id, ExperienciaTotal experiencia) {

        Optional<ExperienciaTotalDto> busqueda = experienciaTotalRepository.findById(id);
        if(busqueda.isPresent()){
            ExperienciaTotal actualizada = experienciaTotalRepository.save(experiencia);
            return experienciaTotalMapper.toDto(actualizada);
        }else{
            return null;
        }

    }

    public void borrarExperiencia(int id) {
        experienciaTotalRepository.deleteById(id);
    }
}
