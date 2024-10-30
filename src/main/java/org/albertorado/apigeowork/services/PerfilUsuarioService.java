package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.PerfilUsuarioDto;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.albertorado.apigeowork.mapper.PerfilUsuarioMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.PerfilUsuarioRepository;

import java.util.Optional;

@Service
public class PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilUsuarioRepository;
    private final PerfilUsuarioMapper perfilUsuarioMapper;

    public PerfilUsuarioService(PerfilUsuarioRepository perfilUsuarioRepository,PerfilUsuarioMapper perfilUsuarioMapper) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
        this.perfilUsuarioMapper = perfilUsuarioMapper;
    }

    public PerfilUsuarioDto buscarPerfilUPorId(int id) {
        Optional<PerfilUsuarioDto> resultado = perfilUsuarioRepository.findByIdPerfil(id);

        return resultado.orElseGet(null);
    }

    public PerfilUsuarioDto crearPerfilU(PerfilUsuario perfilUsuario) {
        PerfilUsuario creado = perfilUsuarioRepository.save(perfilUsuario);
        return perfilUsuarioMapper.toDto(creado);
    }

    public PerfilUsuarioDto actualizarPerfilU(int id, PerfilUsuario perfilUsuario) {
        Optional<PerfilUsuarioDto> busqueda = perfilUsuarioRepository.findByIdPerfil(id);
        if(busqueda.isPresent()){
            perfilUsuarioRepository.save(perfilUsuario);
            Optional<PerfilUsuarioDto> resultado = perfilUsuarioRepository.findByIdPerfil(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }
    }

    public void eliminarPerfilU(int id) {
        perfilUsuarioRepository.deleteByIdPerfil(id);
    }
}
