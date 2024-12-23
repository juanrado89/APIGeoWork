package org.albertorado.apigeowork.services;

import jakarta.transaction.Transactional;
import org.albertorado.apigeowork.dtos.OfertaEmpleoDto;
import org.albertorado.apigeowork.dtos.OfertaEmpleoFiltroDto;
import org.albertorado.apigeowork.entities.HorarioEntrevista;
import org.albertorado.apigeowork.entities.OfertaEmpleo;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.albertorado.apigeowork.especificaciones.OfertaEmpleoEspecificaciones;
import org.albertorado.apigeowork.mapper.OfertaEmpleoMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.OfertaEmpleoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfertaEmpleoService {

    private final OfertaEmpleoRepository ofertaEmpleoRepository;
    private final OfertaEmpleoMapper ofertaEmpleoMapper;

    public OfertaEmpleoService(OfertaEmpleoRepository ofertaEmpleoRepository, OfertaEmpleoMapper ofertaEmpleoMapper) {
        this.ofertaEmpleoRepository = ofertaEmpleoRepository;
        this.ofertaEmpleoMapper = ofertaEmpleoMapper;
    }

    public OfertaEmpleoDto buscarPorId(int id) {
        Optional<OfertaEmpleo> oferta = ofertaEmpleoRepository.findByIdOferta(id);
        if(oferta.isEmpty()){
            return null;
        }
        return ofertaEmpleoMapper.toDto(oferta.get());
    }

    public OfertaEmpleoDto crearOfertaEmpleo(OfertaEmpleo ofertaEmpleo) {
        OfertaEmpleo creado = ofertaEmpleoRepository.save(ofertaEmpleo);
        return ofertaEmpleoMapper.toDto(creado);
    }

    @Transactional
    public OfertaEmpleoDto actualizarOferta(int id, OfertaEmpleo ofertaEmpleo) {
        Optional<OfertaEmpleo> busqueda = ofertaEmpleoRepository.findByIdOferta(id);

        if (busqueda.isPresent()) {
            OfertaEmpleo ofertaExistente = busqueda.get();

            if (ofertaEmpleo.getTitulo() != null) {
                ofertaExistente.setTitulo(ofertaEmpleo.getTitulo());
            }
            if (ofertaEmpleo.getCantidad() != 0) {
                ofertaExistente.setCantidad(ofertaEmpleo.getCantidad());
            }
            if (ofertaEmpleo.getDescripcion() != null) {
                ofertaExistente.setDescripcion(ofertaEmpleo.getDescripcion());
            }
            if (ofertaEmpleo.getRequisitos() != null) {
                ofertaExistente.setRequisitos(ofertaEmpleo.getRequisitos());
            }
            if (ofertaEmpleo.getSalarioMin() != 0) {
                ofertaExistente.setSalarioMin(ofertaEmpleo.getSalarioMin());
            }
            if (ofertaEmpleo.getSalarioMax() != 0) {
                ofertaExistente.setSalarioMax(ofertaEmpleo.getSalarioMax());
            }
            if (ofertaEmpleo.getFechaPublicacion() != null) {
                ofertaExistente.setFechaPublicacion(ofertaEmpleo.getFechaPublicacion());
            }
            if (!ofertaEmpleo.getEstado()) {
                ofertaExistente.setEstado(ofertaEmpleo.getEstado());
            }
            if (ofertaEmpleo.getEmpresa() != null) {
                ofertaExistente.setEmpresa(ofertaEmpleo.getEmpresa());
            }
            if (ofertaEmpleo.getSector() != null) {
                ofertaExistente.setSector(ofertaEmpleo.getSector());
            }
            if (ofertaEmpleo.getNivel() != null) {
                ofertaExistente.setNivelEducativo(ofertaEmpleo.getNivel());
            }
            if (ofertaEmpleo.getDireccion() != null) {
                ofertaExistente.setDireccion(ofertaEmpleo.getDireccion());
            }
            if (ofertaEmpleo.getHorarios() != null && !ofertaEmpleo.getHorarios().isEmpty()) {
                List<HorarioEntrevista> horariosActualizados = new ArrayList<>();
                for(HorarioEntrevista horario : ofertaEmpleo.getHorarios()){
                    horariosActualizados.add(horario);
                }
                ofertaExistente.getHorarios().addAll(horariosActualizados);
            }
            if(ofertaEmpleo.getTrabajadores() != null && !ofertaEmpleo.getTrabajadores().isEmpty()){
                List<PerfilUsuario> trabajadoresActualizados = new ArrayList<>();
                for(PerfilUsuario perfil : ofertaEmpleo.getTrabajadores()){
                    trabajadoresActualizados.add(perfil);
                }
                ofertaExistente.getTrabajadores().addAll(trabajadoresActualizados);
            }
            OfertaEmpleo actualizada = ofertaEmpleoRepository.save(ofertaExistente);
            return ofertaEmpleoMapper.toDto(actualizada);
        } else {
            return null;
        }
    }


    public void borrarOferta(int id) {
        ofertaEmpleoRepository.deleteById(id);
    }

    @Transactional
    public List<OfertaEmpleoDto> buscarPorParametros(OfertaEmpleoFiltroDto parametros) {
        Specification<OfertaEmpleo> especificaciones = Specification.where(
                OfertaEmpleoEspecificaciones.tienePais(parametros.getPais())
                        .and(OfertaEmpleoEspecificaciones.tieneEstado(parametros.getEstado()))
                        .and(OfertaEmpleoEspecificaciones.tieneCiudad(parametros.getCiudad()))
                        .and(OfertaEmpleoEspecificaciones.tieneTitulo(parametros.getTitulo()))
                        .and(OfertaEmpleoEspecificaciones.tieneSector(parametros.getSector()))
                        .and(OfertaEmpleoEspecificaciones.tieneNivel(parametros.getNivel()))
                        .and(OfertaEmpleoEspecificaciones.salarioMayorQue(parametros.getSalarioMin()))
                        .and(OfertaEmpleoEspecificaciones.salarioMenorQue(parametros.getSalarioMax()))
                        .and(OfertaEmpleoEspecificaciones.tieneRequisitos(parametros.getRequisitos()))
                        .and(OfertaEmpleoEspecificaciones.estatus(parametros.getEstatus()))
                        .and(OfertaEmpleoEspecificaciones.ordenarPorFecha(false)));
        List<OfertaEmpleo> resultado = ofertaEmpleoRepository.findAll(especificaciones);
        return ofertaEmpleoMapper.toDto(resultado);
    }

    @Transactional
    public List<OfertaEmpleoDto> buscarPorIdEmpresa(int id) {
        List<OfertaEmpleo> resultado = ofertaEmpleoRepository.findAllByEmpresa_IdEmpresaOrderByFechaPublicacionDesc(id);
        return ofertaEmpleoMapper.toDto(resultado);
    }
    @Transactional
    public List<OfertaEmpleoDto> buscarPorIdUsuario(int id) {
        List<OfertaEmpleo> resultado = ofertaEmpleoRepository.findAllByTrabajadores_IdPerfilOrderByFechaPublicacionDesc(id);
        return ofertaEmpleoMapper.toDto(resultado);
    }

    @Transactional
    public List<OfertaEmpleoDto> buscarTodas() {
        List<OfertaEmpleo> resultado = ofertaEmpleoRepository.findAllOrderByFechaPublicacionDesc();
        return ofertaEmpleoMapper.toDto(resultado);
    }
}
