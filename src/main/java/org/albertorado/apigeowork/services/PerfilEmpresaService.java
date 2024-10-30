package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.PerfilEmpresaDto;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.albertorado.apigeowork.mapper.PerfilEmpresaMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.PerfilEmpresaRepository;

import java.util.Optional;

@Service
public class PerfilEmpresaService {

    private final PerfilEmpresaRepository perfilEmpresaRepository;
    private final PerfilEmpresaMapper perfilEmpresaMapper;

    public PerfilEmpresaService(PerfilEmpresaRepository perfilEmpresaRepository, PerfilEmpresaMapper perfilEmpresaMapper) {
        this.perfilEmpresaRepository = perfilEmpresaRepository;
        this.perfilEmpresaMapper = perfilEmpresaMapper;
    }

    public PerfilEmpresaDto buscarPerfilEPorId(int id) {
        Optional<PerfilEmpresaDto> perfil = perfilEmpresaRepository.findByIdUsuario(id);
        return perfil.orElseGet(null);
    }

    public PerfilEmpresaDto crearPerfilE(PerfilEmpresa perfilEmpresa) {
        PerfilEmpresa creado = perfilEmpresaRepository.save(perfilEmpresa);
        return perfilEmpresaMapper.toDto(creado);
    }

    public PerfilEmpresaDto actualizarPerfilE(int id, PerfilEmpresa perfilEmpresa) {
        Optional<PerfilEmpresaDto> busqueda = perfilEmpresaRepository.findByIdUsuario(id);
        if(busqueda.isPresent()){
            perfilEmpresaRepository.save(perfilEmpresa);
            Optional<PerfilEmpresaDto> resultado = perfilEmpresaRepository.findByIdUsuario(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }
    }

    public void eliminarPerfilE(int id) {
        perfilEmpresaRepository.deletePerfilEmpresaByIdUsuario(id);
    }
}
