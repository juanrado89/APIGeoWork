package services;

import dtos.DatosDto;
import entities.Datos;
import mapper.DatosMapper;
import repositories.DatosRepository;

import java.util.Optional;

public class DatosService {

    private final DatosRepository datosRepository;
    private final DatosMapper datosMapper;

    public DatosService(DatosRepository datosRepository, DatosMapper datosMapper) {
        this.datosRepository = datosRepository;
        this.datosMapper = datosMapper;
    }

    public DatosDto buscarPorId(int id) {
        Optional<DatosDto> resultado = datosRepository.findDatosByIdDatos(id);
        return resultado.orElseGet(null);
    }

    public DatosDto crearDatos(Datos datos) {

        Datos creado = datosRepository.save(datos);
        return datosMapper.toDto(creado);

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
