package org.albertorado.apigeowork.services;

import jakarta.transaction.Transactional;
import org.albertorado.apigeowork.dtos.DescripcionExperienciaDto;
import org.albertorado.apigeowork.entities.DescripcionExperiencia;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.albertorado.apigeowork.mapper.DescripcionExperienciaMapper;
import org.albertorado.apigeowork.repositories.ExperienciaTotalRepository;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.DescripcionExperienciaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DescripcionExperienciaSerice {

    private final DescripcionExperienciaRepository descripcionExperienciaRepository;
    private final DescripcionExperienciaMapper descripcionExperienciaMapper;
    private final ExperienciaTotalRepository experienciaTotalRepository;

    public DescripcionExperienciaSerice(DescripcionExperienciaRepository descripcionExperienciaRepository, DescripcionExperienciaMapper descripcionExperienciaMapper, ExperienciaTotalRepository experienciaTotalRepository) {
        this.descripcionExperienciaRepository = descripcionExperienciaRepository;
        this.descripcionExperienciaMapper = descripcionExperienciaMapper;
        this.experienciaTotalRepository = experienciaTotalRepository;
    }

    @Transactional
    public List<DescripcionExperienciaDto> buscarPorIdExperienciaTotal(int id) {
        List<DescripcionExperiencia> resultado = descripcionExperienciaRepository.findAllByExperienciaTotal_IdExperienciaTotal(id);
        if(resultado.isEmpty()){
            return null;
        }
        return descripcionExperienciaMapper.toDto(resultado);
    }
    @Transactional
    public DescripcionExperienciaDto buscarPorId(int id) {
        Optional<DescripcionExperiencia> resultado = descripcionExperienciaRepository.findByIdDescripcionExperiencia(id);
        if(resultado.isEmpty()){
            return null;
        }
        return descripcionExperienciaMapper.toDto(resultado.get());
    }

    public DescripcionExperienciaDto crearDescripcionExperiencia(DescripcionExperiencia descripcionExperiencia) {

        DescripcionExperiencia creada = descripcionExperienciaRepository.save(descripcionExperiencia);
        return descripcionExperienciaMapper.toDto(creada);
    }

    public DescripcionExperienciaDto actualizarDescripcionExperiencia(int id, DescripcionExperiencia descripcionExperiencia) {
        Optional<DescripcionExperiencia> busqueda = descripcionExperienciaRepository.findByIdDescripcionExperiencia(id);

        if (busqueda.isPresent()) {
            DescripcionExperiencia descripcionExistente = busqueda.get();
            if (descripcionExperiencia.getNombreEmpresa() != null) {
                descripcionExistente.setNombreEmpresa(descripcionExperiencia.getNombreEmpresa());
            }
            if (descripcionExperiencia.getDescripcion() != null) {
                descripcionExistente.setDescripcion(descripcionExperiencia.getDescripcion());
            }
            if (descripcionExperiencia.getFechaInicio() != null) {
                descripcionExistente.setFechaInicio(descripcionExperiencia.getFechaInicio());
            }
            if (descripcionExperiencia.getFechaFin() != null) {
                descripcionExistente.setFechaFin(descripcionExperiencia.getFechaFin());
            }
            DescripcionExperiencia actualizada = descripcionExperienciaRepository.save(descripcionExistente);
            return descripcionExperienciaMapper.toDto(actualizada);
        } else {
            return null;
        }
    }


    public void borrarDescripcionExperiencia(int id) {
        descripcionExperienciaRepository.deleteById(id);
    }

    public List<DescripcionExperienciaDto> crearDescripcionesExperiencia(List<DescripcionExperiencia> descripcionExperiencia) {
        ExperienciaTotal experienciaTotal = experienciaTotalRepository.save(descripcionExperiencia.get(0).getExperienciaTotal());
        for(DescripcionExperiencia experiencia : descripcionExperiencia){
            experiencia.setExperienciaTotal(experienciaTotal);
        }
        List<DescripcionExperiencia> creada = descripcionExperienciaRepository.saveAll(descripcionExperiencia);
        return descripcionExperienciaMapper.toDto(creada);
    }
}
