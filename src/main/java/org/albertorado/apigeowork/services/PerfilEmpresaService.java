package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.configuracion.PasswordEncoderProvider;
import org.albertorado.apigeowork.dtos.PerfilEmpresaDto;
import org.albertorado.apigeowork.dtos.PerfilEmpresaPDto;
import org.albertorado.apigeowork.entities.Foto;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.albertorado.apigeowork.mapper.PerfilEmpresaMapper;
import org.albertorado.apigeowork.mapper.PerfilEmpresaPMapper;
import org.albertorado.apigeowork.repositories.FotoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.PerfilEmpresaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PerfilEmpresaService {

    private final PerfilEmpresaRepository perfilEmpresaRepository;
    private final PerfilEmpresaMapper perfilEmpresaMapper;
    private final PerfilEmpresaPMapper perfilEmpresaPMapper;
    private final FotoRepository fotoRepository;
    private final PasswordEncoder passwordEncoder;

    public PerfilEmpresaService(PerfilEmpresaRepository perfilEmpresaRepository, PerfilEmpresaMapper perfilEmpresaMapper, PerfilEmpresaPMapper perfilEmpresaPMapper, FotoRepository fotoRepository, PasswordEncoder passwordEncoder) {
        this.perfilEmpresaRepository = perfilEmpresaRepository;
        this.perfilEmpresaMapper = perfilEmpresaMapper;
        this.perfilEmpresaPMapper = perfilEmpresaPMapper;
        this.fotoRepository = fotoRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional(readOnly = true)
    public PerfilEmpresaDto buscarPerfilEPorId(int id) {
        Optional<PerfilEmpresa> perfil = perfilEmpresaRepository.findByIdUsuario(id);
        if(perfil.isEmpty()){
            return null;
        }
        return perfilEmpresaMapper.toDto(perfil.get());
    }
    @Transactional
    public PerfilEmpresaDto crearPerfilE(PerfilEmpresa perfilEmpresa) {
        if(perfilEmpresa.getFoto() != null){
            Foto fotoCreada = fotoRepository.save(perfilEmpresa.getFoto());
            perfilEmpresa.setFoto(fotoCreada);
        }
        PerfilEmpresa creado = perfilEmpresaRepository.save(perfilEmpresa);
        return perfilEmpresaMapper.toDto(creado);
    }
    @Transactional
    public PerfilEmpresaDto actualizarPerfilE(int id, PerfilEmpresa perfilEmpresa) {
        Optional<PerfilEmpresa> busqueda = perfilEmpresaRepository.findByIdUsuario(id);

        if (busqueda.isPresent()) {
            PerfilEmpresa perfilExistente = busqueda.get();
            if (perfilEmpresa.getPassword() != null && !perfilEmpresa.getPassword().isEmpty()) {
                perfilExistente.setPassword(perfilEmpresa.getPassword());
            }
            if (perfilEmpresa.getEmail() != null) {
                perfilExistente.setEmail(perfilEmpresa.getEmail());
            }
            if (perfilEmpresa.getEmpresa() != null) {
                perfilExistente.setEmpresa(perfilEmpresa.getEmpresa());
            }
            if (perfilEmpresa.getFoto() != null && perfilEmpresa.getFoto().getIdFoto() == null) {
                Foto foto = fotoRepository.save(perfilEmpresa.getFoto());
                perfilExistente.setFoto(foto);
            }
            PerfilEmpresa actualizado = perfilEmpresaRepository.save(perfilExistente);
            return perfilEmpresaMapper.toDto(actualizado);
        } else {
            return null;
        }
    }

    public void eliminarPerfilE(int id) {
        perfilEmpresaRepository.deletePerfilEmpresaByIdUsuario(id);
    }

    @Transactional(readOnly = true)
    public PerfilEmpresaPDto buscarPorCorreo(String correo) {
        Optional<PerfilEmpresa> perfil = perfilEmpresaRepository.findPerfilEmpresaByEmailContainingIgnoreCase(correo);
        if(perfil.isEmpty()){
            return null;
        }
        return perfilEmpresaPMapper.toDto(perfil.get());
    }

    @Transactional(readOnly = true)
    public void actualizarContrasena(int id, String contrasena) {
        Optional<PerfilEmpresa> busqueda = perfilEmpresaRepository.findByIdUsuario(id);
        if (busqueda.isPresent()) {
            PerfilEmpresa perfilExistente = busqueda.get();
            perfilExistente.setPassword(contrasena);
            perfilEmpresaRepository.save(perfilExistente);
        }
    }
}
