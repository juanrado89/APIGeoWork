package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.PaisDto;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.PaisRepository;

import java.util.Optional;
@Service
public class PaisService {

    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public PaisDto getPaisPorId(int id) {

        Optional<PaisDto> resultado = paisRepository.findAllByIdPais(id);
        return resultado.orElseGet(null);

    }

    public PaisDto getPaisPorNombre(String nombre) {

        Optional<PaisDto> resultado = paisRepository.findAllByPaisContainsIgnoreCase(nombre);
        return resultado.orElseGet(null);

    }
}
