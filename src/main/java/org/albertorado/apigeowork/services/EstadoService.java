package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.EstadoDto;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.EstadoRepository;

import java.util.Optional;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public EstadoDto buscarEstadoPorId(int id) {

        Optional<EstadoDto> resultado = estadoRepository.findByIdEstado(id);
        return resultado.orElseGet(null);

    }

    public EstadoDto buscarEstadoPorNombre(String nombre) {

        Optional<EstadoDto> resultado = estadoRepository.findByEstadoContainsIgnoreCase(nombre);
        return resultado.orElseGet(null);

    }
}
