package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.EstadoDto;
import org.albertorado.apigeowork.entities.Estado;
import org.albertorado.apigeowork.mapper.EstadoMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.EstadoRepository;

import java.util.Optional;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;
    private final EstadoMapper estadoMapper;

    public EstadoService(EstadoRepository estadoRepository, EstadoMapper estadoMapper) {
        this.estadoRepository = estadoRepository;
        this.estadoMapper = estadoMapper;
    }

    public EstadoDto buscarEstadoPorId(int id) {

        Optional<Estado> resultado = estadoRepository.findByIdEstado(id);
        if(resultado.isEmpty()){
            return null;
        }
        return estadoMapper.toDto(resultado.get());

    }

    public EstadoDto buscarEstadoPorNombre(String nombre) {

        Optional<Estado> resultado = estadoRepository.findByEstadoContainsIgnoreCase(nombre);
        if(resultado.isEmpty()){
            return null;
        }
        return estadoMapper.toDto(resultado.get());

    }
}
