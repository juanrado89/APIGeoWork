package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.DescripcionExperienciaDto;
import org.albertorado.apigeowork.entities.DescripcionExperiencia;
import org.albertorado.apigeowork.mapper.DescripcionExperienciaMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.DescripcionExperienciaRepository;

import java.util.Optional;

@Service
public class DescripcionExperienciaSerice {

    private final DescripcionExperienciaRepository descripcionExperienciaRepository;
    private final DescripcionExperienciaMapper descripcionExperienciaMapper;

    public DescripcionExperienciaSerice(DescripcionExperienciaRepository descripcionExperienciaRepository, DescripcionExperienciaMapper descripcionExperienciaMapper) {
        this.descripcionExperienciaRepository = descripcionExperienciaRepository;
        this.descripcionExperienciaMapper = descripcionExperienciaMapper;
    }

    public DescripcionExperienciaDto buscarPorId(int id) {
        Optional<DescripcionExperienciaDto> resultado = descripcionExperienciaRepository.findByIdDescripcionExperiencia(id);
        return resultado.orElseGet(null);
    }

    public DescripcionExperienciaDto crearDescripcionExperiencia(DescripcionExperiencia descripcionExperiencia) {
        DescripcionExperiencia creada = descripcionExperienciaRepository.save(descripcionExperiencia);
        return descripcionExperienciaMapper.toDto(creada);
    }

    public DescripcionExperienciaDto actualizarDescripcionExperiencia(int id, DescripcionExperiencia descripcionExperiencia) {
        Optional<DescripcionExperienciaDto> busqueda = descripcionExperienciaRepository.findByIdDescripcionExperiencia(id);
        if(busqueda.isPresent()){
            DescripcionExperiencia actualizada = descripcionExperienciaRepository.save(descripcionExperiencia);
            return descripcionExperienciaMapper.toDto(actualizada);
        }else{
            return null;
        }
    }

    public void borrarDescripcionExperiencia(int id) {
        descripcionExperienciaRepository.deleteById(id);
    }

}
