package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.PaisDto;
import org.albertorado.apigeowork.entities.Pais;
import org.albertorado.apigeowork.mapper.PaisMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.PaisRepository;

import java.util.List;
import java.util.Optional;
@Service
public class PaisService {

    private final PaisRepository paisRepository;
    private final PaisMapper paisMapper;

    public PaisService(PaisRepository paisRepository, PaisMapper paisMapper) {
        this.paisRepository = paisRepository;
        this.paisMapper = paisMapper;
    }

    public PaisDto getPaisPorId(int id) {

        Optional<Pais> resultado = paisRepository.findAllByIdPais(id);
        if(resultado.isEmpty()){
            return null;
        }
        return paisMapper.toDto(resultado.get());

    }

    public PaisDto getPaisPorNombre(String nombre) {

        Optional<Pais> resultado = paisRepository.findAllByPaisContainsIgnoreCase(nombre);
        if(resultado.isEmpty()){
            return null;
        }
        return paisMapper.toDto(resultado.get());

    }

    public List<PaisDto> buscarTodos() {
        List<Pais> resultado = paisRepository.findAll();
        return paisMapper.toDto(resultado);
    }
}
