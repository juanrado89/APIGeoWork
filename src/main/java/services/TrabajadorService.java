package services;

import dtos.TrabajadorDto;
import entities.Trabajador;
import mapper.TrabajadorMapper;
import org.springframework.stereotype.Service;
import repositories.TrabajadorRepository;

import java.util.Optional;

@Service
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;
    private final TrabajadorMapper trabajadorMapper;

    public TrabajadorService(TrabajadorRepository trabajadorRepository, TrabajadorMapper trabajadorMapper) {
        this.trabajadorRepository = trabajadorRepository;
        this.trabajadorMapper = trabajadorMapper;
    }

    public TrabajadorDto crearTrabajador(Trabajador trabajador) {
        Trabajador creado = trabajadorRepository.save(trabajador);
        return trabajadorMapper.toDto(creado);
    }

    public TrabajadorDto buscarTrabajadorPorId(int id) {
        Optional<TrabajadorDto> resultado = trabajadorRepository.findTrabajadorByIdTrabajador(id);
        return resultado.orElseGet(null);
    }

    public TrabajadorDto actualizarTrabajador(int id, Trabajador trabajador) {
        Optional<TrabajadorDto> resultado = trabajadorRepository.findTrabajadorByIdTrabajador(id);
        if(resultado.isPresent()){
            trabajadorRepository.save(trabajador);
            Optional<TrabajadorDto> actualizado = trabajadorRepository.findTrabajadorByIdTrabajador(id);
            return actualizado.orElseGet(null);
        }
        return null;
    }

    public void borrarTrabajador(int id) {
        trabajadorRepository.deleteByIdTrabajador(id);
    }
}
