package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.NivelEducativoDto;
import org.albertorado.apigeowork.entities.NivelEducativo;
import org.albertorado.apigeowork.mapper.NivelEducativoMapper;
import org.albertorado.apigeowork.repositories.NivelEducativoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelEducativoService {

    private final NivelEducativoRepository nivelEducativoRepository;
    private final NivelEducativoMapper nivelEducativoMapper;

    public NivelEducativoService(NivelEducativoRepository nivelEducativoRepository, NivelEducativoMapper nivelEducativoMapper) {
        this.nivelEducativoRepository = nivelEducativoRepository;
        this.nivelEducativoMapper = nivelEducativoMapper;
    }

    public NivelEducativoDto buscarPorId(int id) {
        Optional<NivelEducativo> resultado = nivelEducativoRepository.findById(id);
        if(resultado.isEmpty()){
            return null;
        }
        return nivelEducativoMapper.toDto(resultado.get());
    }

    public List<NivelEducativoDto> buscarPortitulo(String titulo) {
        List<NivelEducativo> resultado = nivelEducativoRepository.findAllByTituloNivelEducativoContainingIgnoreCase(titulo);
        return nivelEducativoMapper.toDto(resultado);

    }

    public NivelEducativoDto crearNivelEducativo(NivelEducativo nivelEducativo) {
        NivelEducativo crear = nivelEducativoRepository.save(nivelEducativo);
        return nivelEducativoMapper.toDto(crear);
    }

    public NivelEducativoDto actualizarNivelEducativo(int id, NivelEducativo nivelEducativo) {
        Optional<NivelEducativo> busqueda = nivelEducativoRepository.findById(id);

        if (busqueda.isPresent()) {
            NivelEducativo nivelExistente = busqueda.get();
            if (nivelEducativo.getTituloNivelEducativo() != null) {
                nivelExistente.setTituloNivelEducativo(nivelEducativo.getTituloNivelEducativo());
            }
            if (nivelEducativo.getCentroEducativo() != null) {
                nivelExistente.setCentroEducativo(nivelEducativo.getCentroEducativo());
            }
            if (nivelEducativo.getFechaInicio() != null) {
                nivelExistente.setFechaInicio(nivelEducativo.getFechaInicio());
            }
            if (nivelEducativo.getFechaFin() != null) {
                nivelExistente.setFechaFin(nivelEducativo.getFechaFin());
            }
            if (nivelEducativo.getNivel() != null) {
                nivelExistente.setNivel(nivelEducativo.getNivel());
            }
            NivelEducativo actualizado = nivelEducativoRepository.save(nivelExistente);
            return nivelEducativoMapper.toDto(actualizado);
        } else {
            return null;
        }
    }

    public void borrarNivelEducativo(int id) {
        nivelEducativoRepository.deleteById(id);
    }
}
