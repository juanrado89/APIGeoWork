package services;

import dtos.DatosDto;
import entities.Datos;
import repositories.DatosRepository;

import java.util.Optional;

public class DatosService {

    private final DatosRepository datosRepository;

    public DatosService(DatosRepository datosRepository) {
        this.datosRepository = datosRepository;
    }

    public DatosDto buscarPorId(int id) {
        Optional<DatosDto> resultado = datosRepository.findDatosByIdDatos(id);
        return resultado.orElseGet(null);
    }

    public DatosDto crearDatos(Datos datos) {

        Optional<DatosDto> busqueda = datosRepository.findDatosByNombreContainsIgnoreCaseAndApellidosContainsIgnoreCaseAndDireccion_IdDireccion(datos.getNombre(),datos.getApellidos(),datos.getDireccion().getIdDireccion());
        if(busqueda.isPresent()){
            return null;
        }else{
            datosRepository.save(datos);
            Optional<DatosDto> resultado = datosRepository.findDatosByNombreContainsIgnoreCaseAndApellidosContainsIgnoreCaseAndDireccion_IdDireccion(datos.getNombre(),datos.getApellidos(),datos.getDireccion().getIdDireccion());
            return resultado.orElseGet(null);
        }

    }

    public DatosDto actualizarDatos(int id, Datos datos) {

        Optional<DatosDto> busqueda = datosRepository.findDatosByIdDatos(id);
        if(busqueda.isPresent()){
            datosRepository.save(datos);
            Optional<DatosDto> resultado = datosRepository.findDatosByIdDatos(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }

    }

    public void borrarDatos(int id) {

        datosRepository.deleteByIdDatos(id);

    }
}
