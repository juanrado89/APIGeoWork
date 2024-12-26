package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.configuracion.EvitarCiclosMapping;
import org.albertorado.apigeowork.configuracion.PasswordEncoderProvider;
import org.albertorado.apigeowork.dtos.PerfilUsuarioDto;
import org.albertorado.apigeowork.dtos.PerfilUsuarioPDto;
import org.albertorado.apigeowork.entities.Foto;
import org.albertorado.apigeowork.entities.HorarioEntrevista;
import org.albertorado.apigeowork.entities.OfertaEmpleo;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.albertorado.apigeowork.mapper.PerfilUsuarioMapper;
import org.albertorado.apigeowork.mapper.PerfilUsuarioPMapper;
import org.albertorado.apigeowork.repositories.FotoRepository;
import org.albertorado.apigeowork.repositories.HorarioEntrevistaRepository;
import org.albertorado.apigeowork.repositories.OfertaEmpleoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.PerfilUsuarioRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilUsuarioRepository;
    private final PerfilUsuarioMapper perfilUsuarioMapper;
    private final PerfilUsuarioPMapper perfilUsuarioPMapper;
    private final FotoRepository fotoRepository;
    private final OfertaEmpleoRepository ofertaEmpleoRepository;
    private final HorarioEntrevistaRepository horarioEntrevistaRepository;

    public PerfilUsuarioService(PerfilUsuarioRepository perfilUsuarioRepository, PerfilUsuarioMapper perfilUsuarioMapper,
                                PerfilUsuarioPMapper perfilUsuarioPMapper, FotoRepository fotoRepository,
                                OfertaEmpleoRepository ofertaEmpleoRepository,
                                HorarioEntrevistaRepository horarioEntrevistaRepository) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
        this.perfilUsuarioMapper = perfilUsuarioMapper;
        this.perfilUsuarioPMapper = perfilUsuarioPMapper;
        this.fotoRepository = fotoRepository;
        this.ofertaEmpleoRepository = ofertaEmpleoRepository;
        this.horarioEntrevistaRepository = horarioEntrevistaRepository;
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
        if(perfilUsuario.getFoto() != null){
            Foto fotoCreada = fotoRepository.save(perfilUsuario.getFoto());
            perfilUsuario.setFoto(fotoCreada);
        }
        PerfilUsuario creado = perfilUsuarioRepository.save(perfilUsuario);
        return perfilUsuarioMapper.toDto(creado);
    }
    @Transactional
    public PerfilUsuarioDto actualizarPerfilU(int id, PerfilUsuario perfilUsuario) {
        Optional<PerfilUsuario> busqueda = perfilUsuarioRepository.findByIdPerfil(id);

        if (busqueda.isPresent()) {
            PerfilUsuario perfilExistente = busqueda.get();
            if (perfilUsuario.getPassword() != null && !perfilUsuario.getPassword().isEmpty()) {
                perfilExistente.setPassword(perfilUsuario.getPassword());
            }
            if (perfilUsuario.getEmail() != null) {
                perfilExistente.setEmail(perfilUsuario.getEmail());
            }
            if (perfilUsuario.getTrabajador() != null) {
                perfilExistente.setTrabajador(perfilUsuario.getTrabajador());
            }
            if (perfilUsuario.getFoto() != null && perfilUsuario.getFoto().getIdFoto() == null) {
                Foto foto = fotoRepository.save(perfilUsuario.getFoto());
                perfilExistente.setFoto(foto);
            }if(perfilUsuario.getOfertas() != null && perfilUsuario.getOfertas().size() > 0){
                List<OfertaEmpleo> ofertasActualizadas  = new ArrayList<>();
                for(OfertaEmpleo oferta : perfilUsuario.getOfertas()){
                    ofertasActualizadas.add(oferta);
                }
                List<OfertaEmpleo> ofertas = ofertaEmpleoRepository.saveAll(ofertasActualizadas);
                perfilExistente.setOfertas(ofertas);
            }if(perfilUsuario.getHorarios() != null && perfilUsuario.getHorarios().size() > 0){
                List<HorarioEntrevista> horariosActualizados = new ArrayList<>();
                for(HorarioEntrevista horarios : perfilUsuario.getHorarios()){
                    horariosActualizados.add(horarios);
                }
                List<HorarioEntrevista> horarios = horarioEntrevistaRepository.saveAll(horariosActualizados);
                perfilExistente.setHorarios(horarios);
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
    public void cambiarContrsena(int id, String password) {
        Optional<PerfilUsuario> busqueda = perfilUsuarioRepository.findByIdPerfil(id);
        if(busqueda.isPresent()){
            PerfilUsuario perfilExistente = busqueda.get();
            perfilExistente.setPassword(password);
            perfilUsuarioRepository.save(perfilExistente);
        }
    }

    public List<PerfilUsuarioDto> buscarTodos() {
        List<PerfilUsuario> perfiles = perfilUsuarioRepository.findAll();
        return perfilUsuarioMapper.toDto(perfiles);
    }
}
