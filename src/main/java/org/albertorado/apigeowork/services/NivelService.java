package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.NivelDto;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.NivelRepository;

import java.util.Optional;

@Service
public class NivelService {

    private final NivelRepository nivelRepository;

    public NivelService(NivelRepository nivelRepository) {
        this.nivelRepository = nivelRepository;
    }

    public NivelDto buscarPorId(int id) {
        Optional<NivelDto> resultado = nivelRepository.findNivelByIdNivel(id);
        return resultado.orElse(null);
    }

    public NivelDto buscarPorNombre(String nombre) {
        Optional<NivelDto> resultado = nivelRepository.findNivelByNombreNivelContainingIgnoreCase(nombre);
        return resultado.orElse(null);
    }
}
