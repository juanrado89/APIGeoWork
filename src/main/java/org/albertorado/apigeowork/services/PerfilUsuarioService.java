package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.PerfilUsuarioDto;
import org.albertorado.apigeowork.dtos.PerfilUsuarioPDto;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.albertorado.apigeowork.mapper.PerfilUsuarioMapper;
import org.albertorado.apigeowork.mapper.PerfilUsuarioPMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.PerfilUsuarioRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilUsuarioRepository;
    private final PerfilUsuarioMapper perfilUsuarioMapper;
    private final PerfilUsuarioPMapper perfilUsuarioPMapper;

    public PerfilUsuarioService(PerfilUsuarioRepository perfilUsuarioRepository, PerfilUsuarioMapper perfilUsuarioMapper, PerfilUsuarioPMapper perfilUsuarioPMapper) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
        this.perfilUsuarioMapper = perfilUsuarioMapper;
        this.perfilUsuarioPMapper = perfilUsuarioPMapper;
    }

    @Transactional(readOnly = true)
    public PerfilUsuarioDto buscarPerfilUPorId(int id) {
        Optional<PerfilUsuario> resultado = perfilUsuarioRepository.findByIdPerfil(id);

        if(resultado.isPresent()){
            return perfilUsuarioMapper.toDto(resultado.get());
        }
        return null;
    }
    @Transactional
    public PerfilUsuarioDto crearPerfilU(PerfilUsuario perfilUsuario) {
        PerfilUsuario creado = perfilUsuarioRepository.save(perfilUsuario);
        return perfilUsuarioMapper.toDto(creado);
    }
    @Transactional
    public PerfilUsuarioDto actualizarPerfilU(int id, PerfilUsuario perfilUsuario) {
        Optional<PerfilUsuario> busqueda = perfilUsuarioRepository.findByIdPerfil(id);

        if (busqueda.isPresent()) {
            PerfilUsuario perfilExistente = busqueda.get();
            if (perfilUsuario.getPassword() != null && !perfilUsuario.getPassword().isEmpty()) {
                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                perfilExistente.setPassword(passwordEncoder.encode(perfilUsuario.getPassword()));
            }
            if (perfilUsuario.getEmail() != null) {
                perfilExistente.setEmail(perfilUsuario.getEmail());
            }
            if (perfilUsuario.getTrabajador() != null) {
                perfilExistente.setTrabajador(perfilUsuario.getTrabajador());
            }
            if (perfilUsuario.getFoto() != null) {
                perfilExistente.setFoto(perfilUsuario.getFoto());
            }
            PerfilUsuario actualizado = perfilUsuarioRepository.save(perfilExistente);
            return perfilUsuarioMapper.toDto(actualizado);
        } else {
            return null;
        }
    }

    public void eliminarPerfilU(int id) {
        perfilUsuarioRepository.deleteByIdPerfil(id);
    }

    @Transactional(readOnly = true)
    public PerfilUsuarioPDto buscarPorCorreo(String correo) {
        Optional<PerfilUsuario> resultado = perfilUsuarioRepository.findByEmailContainsIgnoreCase(correo);
        if(resultado.isPresent()){
            return perfilUsuarioPMapper.toDto(resultado.get());
        }
        return null;
    }
    @Transactional(readOnly = true)
    public void cambiarContrsena(String mail, String password) {
        Optional<PerfilUsuario> busqueda = perfilUsuarioRepository.findByEmailContainsIgnoreCase(mail);
        if(busqueda.isPresent()){
            PerfilUsuario perfilExistente = busqueda.get();
            perfilExistente.setPassword(password);
            perfilUsuarioRepository.save(perfilExistente);
        }
    }
}
