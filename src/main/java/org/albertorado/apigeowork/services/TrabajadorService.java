package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.TrabajadorDto;
import org.albertorado.apigeowork.entities.HorarioEntrevista;
import org.albertorado.apigeowork.entities.Trabajador;
import org.albertorado.apigeowork.mapper.TrabajadorMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.TrabajadorRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorMapper trabajadorMapper;

    public TrabajadorService(TrabajadorRepository trabajadorRepository, TrabajadorMapper trabajadorMapper) {
        this.trabajadorRepository = trabajadorRepository;
        this.trabajadorMapper = trabajadorMapper;
    }
    @Transactional
    public TrabajadorDto crearTrabajador(Trabajador trabajador) {
        Trabajador creado = trabajadorRepository.save(trabajador);
        return trabajadorMapper.toDto(creado);
    }
    @Transactional(readOnly = true)
    public TrabajadorDto buscarTrabajadorPorId(int id) {
        Optional<Trabajador> resultado = trabajadorRepository.findTrabajadorByIdTrabajador(id);
        if(resultado.isEmpty()){
            return null;
        }else{
            return trabajadorMapper.toDto(resultado.get());
        }
    }
    @Transactional
    public TrabajadorDto actualizarTrabajador(int id, Trabajador trabajador) {
        Optional<Trabajador> resultado = trabajadorRepository.findTrabajadorByIdTrabajador(id);

        if (resultado.isPresent()) {
            Trabajador trabajadorExistente = resultado.get();
            if (trabajador.getDatosUsuario() != null) {
                trabajadorExistente.setDatosUsuario(trabajador.getDatosUsuario());
            }
            if (trabajador.getDatosExperiencia() != null) {
                trabajadorExistente.setDatosExperiencia(trabajador.getDatosExperiencia());
            }
            Trabajador actualizado = trabajadorRepository.save(trabajadorExistente);
            return trabajadorMapper.toDto(actualizado);
        } else {
            return null;
        }
    }

    public void borrarTrabajador(int id) {
        trabajadorRepository.deleteByIdTrabajador(id);
    }
}
