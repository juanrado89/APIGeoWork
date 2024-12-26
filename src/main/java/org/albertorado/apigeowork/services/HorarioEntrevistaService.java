package org.albertorado.apigeowork.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.albertorado.apigeowork.configuracion.EvitarCiclosMapping;
import org.albertorado.apigeowork.dtos.HorarioEntrevistaDto;
import org.albertorado.apigeowork.dtos.OfertaEmpleoDto;
import org.albertorado.apigeowork.entities.HorarioEntrevista;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.albertorado.apigeowork.especificaciones.HorarioEntrevistaEspecificaciones;
import org.albertorado.apigeowork.mapper.HorarioEntrevistaMapper;
import org.albertorado.apigeowork.repositories.PerfilUsuarioRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.HorarioEntrevistaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioEntrevistaService {

    private final HorarioEntrevistaRepository horarioEntrevistaRepository;
    private final HorarioEntrevistaMapper horarioEntrevistaMapper;
    private final PerfilUsuarioRepository perfilUsuarioRepository;
    private final EvitarCiclosMapping evitarCiclosMapping = new EvitarCiclosMapping();

    public HorarioEntrevistaService(HorarioEntrevistaRepository horarioEntrevistaRepository, HorarioEntrevistaMapper horarioEntrevistaMapper, PerfilUsuarioRepository perfilUsuarioRepository) {
        this.horarioEntrevistaRepository = horarioEntrevistaRepository;
        this.horarioEntrevistaMapper = horarioEntrevistaMapper;
        this.perfilUsuarioRepository = perfilUsuarioRepository;
    }

    public HorarioEntrevistaDto buscarPorId(int id) {
        Optional<HorarioEntrevista> horario = horarioEntrevistaRepository.findByIdHorario(id);
        if(horario.isEmpty()){
            return null;
        }
        return horarioEntrevistaMapper.toDto(horario.get(),evitarCiclosMapping);
    }

    @Transactional
    public List<HorarioEntrevistaDto> buscarPorIdOferta(int id) {
        List<HorarioEntrevista> horarios = horarioEntrevistaRepository.findAllByOfertaEmpleo_IdOfertaOrderByDiaAsc(id);
        return horarioEntrevistaMapper.toDto(horarios, evitarCiclosMapping);
    }

    public HorarioEntrevistaDto crearHorarioEntrevista(HorarioEntrevista horarioEntrevista) {
        HorarioEntrevista creado = horarioEntrevistaRepository.save(horarioEntrevista);
        return horarioEntrevistaMapper.toDto(creado, evitarCiclosMapping);
    }


    public List<HorarioEntrevistaDto> crearHorariosEntrevista(List<HorarioEntrevista> horariosEntrevista) {
        List<HorarioEntrevista> creado = horarioEntrevistaRepository.saveAll(horariosEntrevista);
        return horarioEntrevistaMapper.toDto(creado, evitarCiclosMapping);
    }

    @Transactional
    public HorarioEntrevistaDto actualizarHorario(int id, HorarioEntrevista horarioEntrevista) {
        Optional<HorarioEntrevista> busqueda = horarioEntrevistaRepository.findByIdHorario(id);

        if (busqueda.isEmpty()) {
            return null;
        }
        HorarioEntrevista horarioExistente = busqueda.get();

        if (horarioEntrevista.getOfertaEmpleo() != null) {
            horarioExistente.setOfertaEmpleo(horarioEntrevista.getOfertaEmpleo());
        }
        if (horarioEntrevista.getDia() != null) {
            horarioExistente.setDia(horarioEntrevista.getDia());
        }
        if (horarioEntrevista.getHora() != null) {
            horarioExistente.setHora(horarioEntrevista.getHora());
        }
        if (horarioEntrevista.getCandidatosDisponibles() != 0) {
            horarioExistente.setCandidatosDisponibles(horarioEntrevista.getCandidatosDisponibles());
        }
        if (horarioEntrevista.getCandidatosAsignados() != 0) {
            horarioExistente.setCandidatosAsignados(horarioEntrevista.getCandidatosAsignados());
        }
        if(horarioEntrevista.getTrabajadores() != null && !horarioEntrevista.getTrabajadores().isEmpty()){
            List<PerfilUsuario> trabajadores = new ArrayList<>();
            for(PerfilUsuario trabajador : horarioEntrevista.getTrabajadores()){
                trabajadores.add(trabajador);
            }
            horarioExistente.setTrabajadores(trabajadores);
        }
        HorarioEntrevista actualizado = horarioEntrevistaRepository.save(horarioExistente);
        return horarioEntrevistaMapper.toDto(actualizado, evitarCiclosMapping);
    }


    public void borrarHorario(int id) {
        horarioEntrevistaRepository.deleteById(id);
    }

    @Transactional
    public List<HorarioEntrevistaDto> buscarPorParametros(HorarioEntrevista parametros) {
        Specification<HorarioEntrevista> especificaciones = Specification.where(
                HorarioEntrevistaEspecificaciones.tieneIdOferta(parametros.getOfertaEmpleo().getIdOferta())
                .and(HorarioEntrevistaEspecificaciones.tieneDia(parametros.getDia())
                        .and(HorarioEntrevistaEspecificaciones.tieneHora(parametros.getHora()))
                        .and(HorarioEntrevistaEspecificaciones.tieneDisponibilidad()))
                        .and(HorarioEntrevistaEspecificaciones.ordenarPorDiaAscendente())
                        .and(HorarioEntrevistaEspecificaciones.ordenarPorHoraAscendente()));
        List<HorarioEntrevista> resultado = horarioEntrevistaRepository.findAll(especificaciones);
        return horarioEntrevistaMapper.toDto(resultado, evitarCiclosMapping);
    }

    @Transactional
    public HorarioEntrevistaDto agregarTrabajador(int idHorario, PerfilUsuario perfil) {
        Optional<HorarioEntrevista> busqueda = horarioEntrevistaRepository.findByIdHorario(idHorario);
        if (busqueda.isPresent()) {
            HorarioEntrevista horarioExistente = busqueda.get();

            if(horarioExistente.getCandidatosDisponibles() < horarioExistente.getCandidatosAsignados()){
                horarioExistente.setCandidatosAsignados(horarioExistente.getCandidatosAsignados() + 1);
                if (horarioExistente.getTrabajadores() == null || horarioExistente.getTrabajadores().isEmpty()) {
                    List<PerfilUsuario> listaTrabajadores = new ArrayList<>();
                    horarioExistente.setTrabajadores(listaTrabajadores);
                }
                if (!horarioExistente.getTrabajadores().contains(perfil)) {
                    horarioExistente.getTrabajadores().add(perfil);
                    if (perfil.getOfertas() == null || perfil.getOfertas().isEmpty()) {
                        List<HorarioEntrevista> horariosTrabajador = new ArrayList<>();
                        perfil.setHorarios(horariosTrabajador);
                    }
                    if (!perfil.getHorarios().contains(horarioExistente)) {
                        perfil.getHorarios().add(horarioExistente);
                    }
                    perfilUsuarioRepository.save(perfil);

                }
                HorarioEntrevista horarioActualizado = horarioEntrevistaRepository.save(horarioExistente);
                return horarioEntrevistaMapper.toDto(horarioActualizado, evitarCiclosMapping);
            }else{
                throw new RuntimeException("no hay plazas disponibles para el horario: " + idHorario);
            }
        } else {
            throw new EntityNotFoundException("Oferta de empleo no encontrada con ID: " + idHorario);
        }
    }
}
