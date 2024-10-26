package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.NivelEducativoDto;
import org.albertorado.apigeowork.entities.NivelEducativo;
import org.albertorado.apigeowork.mapper.NivelEducativoMapper;
import org.albertorado.apigeowork.repositories.NivelEducativoRepository;

import java.util.List;
import java.util.Optional;

public class NivelEducativoService {

    private final NivelEducativoRepository nivelEducativoRepository;
    private final NivelEducativoMapper nivelEducativoMapper;

    public NivelEducativoService(NivelEducativoRepository nivelEducativoRepository, NivelEducativoMapper nivelEducativoMapper) {
        this.nivelEducativoRepository = nivelEducativoRepository;
        this.nivelEducativoMapper = nivelEducativoMapper;
    }

    public NivelEducativoDto buscarPorId(int id) {
        Optional<NivelEducativoDto> resultado = nivelEducativoRepository.findById(id);
        return resultado.orElse(null);
    }

    public List<NivelEducativoDto> buscarPortitulo(String titulo) {
        return nivelEducativoRepository.findByTitulo(titulo);

    }

    public NivelEducativoDto crearNivelEducativo(NivelEducativo nivelEducativo) {
        NivelEducativo crear = nivelEducativoRepository.save(nivelEducativo);
        return nivelEducativoMapper.toDto(crear);
    }

    public NivelEducativoDto actualizarNivelEducativo(int id, NivelEducativo nivelEducativo) {
        Optional<NivelEducativoDto> resultado = nivelEducativoRepository.findById(id);
        if(resultado.isPresent()){
            NivelEducativo actualizado = nivelEducativoRepository.save(nivelEducativo);
            return nivelEducativoMapper.toDto(actualizado);
        }
        return null;
    }

    public void borrarNivelEducativo(int id) {
        nivelEducativoRepository.deleteById(id);
    }
}
