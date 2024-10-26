package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.OfertaEmpleoDto;
import org.albertorado.apigeowork.entities.OfertaEmpleo;
import org.albertorado.apigeowork.especificaciones.OfertaEmpleoEspecificaciones;
import org.albertorado.apigeowork.mapper.OfertaEmpleoMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.OfertaEmpleoRepository;

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
        Optional<OfertaEmpleoDto> oferta = ofertaEmpleoRepository.findByIdOferta(id);
        return oferta.orElseGet(null);
    }

    public OfertaEmpleoDto crearOfertaEmpleo(OfertaEmpleo ofertaEmpleo) {
        OfertaEmpleo creado = ofertaEmpleoRepository.save(ofertaEmpleo);
        return ofertaEmpleoMapper.toDto(creado);
    }

    public OfertaEmpleoDto actualizarOferta(int id, OfertaEmpleo ofertaEmpleo) {
        Optional<OfertaEmpleoDto> busqueda = ofertaEmpleoRepository.findByIdOferta(id);
        if(busqueda.isPresent()){
            ofertaEmpleoRepository.save(ofertaEmpleo);
            Optional<OfertaEmpleoDto> resultado = ofertaEmpleoRepository.findByIdOferta(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }
    }

    public void borrarOferta(int id) {
        ofertaEmpleoRepository.deleteById(id);
    }

    public List<OfertaEmpleoDto> buscarPorParametros(OfertaEmpleo parametros) {
        Specification<OfertaEmpleo> especificaciones = Specification.where(
                OfertaEmpleoEspecificaciones.tienePais(parametros.getDireccion().getCiudad().getEstado().getPais().getPais())
                        .and(OfertaEmpleoEspecificaciones.tieneEstado(parametros.getDireccion().getCiudad().getEstado().getEstado()))
                        .and(OfertaEmpleoEspecificaciones.tieneCiudad(parametros.getDireccion().getCiudad().getCiudad()))
                        .and(OfertaEmpleoEspecificaciones.tieneTitulo(parametros.getTitulo()))
                        .and(OfertaEmpleoEspecificaciones.tieneSector(parametros.getSector()))
                        .and(OfertaEmpleoEspecificaciones.tieneNivelEducativo(parametros.getNivelEducativo().getTituloNivelEducativo()))
                        .and(OfertaEmpleoEspecificaciones.salarioMayorQue(parametros.getSalarioMin()))
                        .and(OfertaEmpleoEspecificaciones.salarioMenorQue(parametros.getSalarioMax()))
                        .and(OfertaEmpleoEspecificaciones.tieneRequisitos(parametros.getRequisitos()))
                        .and(OfertaEmpleoEspecificaciones.estatus(parametros.getEstado()))
                        .and(OfertaEmpleoEspecificaciones.ordenarPorFecha(false)));
        List<OfertaEmpleo> resultado = ofertaEmpleoRepository.findAll(especificaciones);
        return ofertaEmpleoMapper.toDto(resultado);
    }
}
