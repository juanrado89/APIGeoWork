package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.NivelDto;
import org.albertorado.apigeowork.entities.Nivel;
import org.albertorado.apigeowork.mapper.NivelMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.NivelRepository;

import java.util.Optional;

@Service
public class NivelService {

    private final NivelRepository nivelRepository;
    private final NivelMapper nivelMapper;

    public NivelService(NivelRepository nivelRepository, NivelMapper nivelMapper) {
        this.nivelRepository = nivelRepository;
        this.nivelMapper = nivelMapper;
    }

    public NivelDto buscarPorId(int id) {
        Optional<Nivel> resultado = nivelRepository.findNivelByIdNivel(id);
        if(resultado.isEmpty()){
            return null;
        }
        return nivelMapper.toDto(resultado.get());
    }

    public NivelDto buscarPorNombre(String nombre) {
        Optional<Nivel> resultado = nivelRepository.findNivelByNombreNivelContainingIgnoreCase(nombre);
        if(resultado.isEmpty()){
            return null;
        }
        return nivelMapper.toDto(resultado.get());
    }
}
