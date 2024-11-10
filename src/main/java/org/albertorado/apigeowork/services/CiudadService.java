package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.CiudadDto;
import org.albertorado.apigeowork.entities.Ciudad;
import org.albertorado.apigeowork.mapper.CiudadMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.CiudadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    private final CiudadRepository ciudadRepository;
    private final CiudadMapper ciudadMapper;

    public CiudadService(CiudadRepository ciudadRepository, CiudadMapper ciudadMapper) {
        this.ciudadRepository = ciudadRepository;
        this.ciudadMapper = ciudadMapper;
    }


    public CiudadDto buscarCiudadPorId(int id) {

        Optional<Ciudad> resultado = ciudadRepository.findByIdCiudad(id);
        if(resultado.isEmpty()){
            return null;
        }
        return ciudadMapper.toDto(resultado.get());

    }

    public CiudadDto buscarCiudadPorNombre(String nombre) {

        Optional<Ciudad> resultado = ciudadRepository.findByCiudadContainsIgnoreCase(nombre);
        if(resultado.isEmpty()){
            return null;
        }
        return ciudadMapper.toDto(resultado.get());

    }

    public List<CiudadDto> buscarTodos() {
        List<Ciudad> resultado = ciudadRepository.findAll();
        return ciudadMapper.toDto(resultado);
    }
}
