package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.albertorado.apigeowork.mapper.ExperienciaTotalMapper;
import org.albertorado.apigeowork.repositories.ExperienciaTotalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExperienciaTotalService {

    private final ExperienciaTotalRepository experienciaTotalRepository;
    private final ExperienciaTotalMapper experienciaTotalMapper;

    public ExperienciaTotalService(ExperienciaTotalRepository experienciaTotalRepository, ExperienciaTotalMapper experienciaTotalMapper) {
        this.experienciaTotalRepository = experienciaTotalRepository;
        this.experienciaTotalMapper = experienciaTotalMapper;
    }

    public ExperienciaTotalDto buscarPorId(int id) {
        Optional<ExperienciaTotal> resultado = experienciaTotalRepository.findById(id);
        if(resultado.isEmpty()){
            return null;
        }
        return experienciaTotalMapper.toDto(resultado.get());
    }

    public ExperienciaTotalDto crearExperiencia(ExperienciaTotal experienciaTotal) {
        ExperienciaTotal creada = experienciaTotalRepository.save(experienciaTotal);
        return experienciaTotalMapper.toDto(creada);
    }

    public ExperienciaTotalDto actualizarExperiencia(int id, ExperienciaTotal experiencia) {

        Optional<ExperienciaTotal> busqueda = experienciaTotalRepository.findById(id);
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
