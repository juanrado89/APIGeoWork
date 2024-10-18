package services;

import dtos.TrabajadorDto;
import entities.Trabajador;
import org.springframework.stereotype.Service;
import repositories.TrabajadorRepository;

import java.util.Optional;

@Service
public class TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    public TrabajadorService(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    public TrabajadorDto crearTrabajador(Trabajador trabajador) {
        TrabajadorDto busqueda = buscarTrabajadorPorId(trabajador.getIdTrabajador());
        if(busqueda != null){
            return busqueda;
        }else{
            trabajadorRepository.save(trabajador);
            Optional<TrabajadorDto> resultado = trabajadorRepository.findTrabajadorByDatosUsuario_IdDatos(trabajador.getDatosUsuario().getIdDatos());
            return resultado.orElseGet(null);
        }
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
