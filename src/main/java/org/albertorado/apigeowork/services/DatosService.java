package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.DatosDto;
import org.albertorado.apigeowork.entities.Datos;
import org.albertorado.apigeowork.mapper.DatosMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.DatosRepository;

import java.util.Optional;

@Service
public class DatosService {

    private final DatosRepository datosRepository;
    private final DatosMapper datosMapper;

    public DatosService(DatosRepository datosRepository, DatosMapper datosMapper) {
        this.datosRepository = datosRepository;
        this.datosMapper = datosMapper;
    }

    public DatosDto buscarPorId(int id) {
        Optional<Datos> resultado = datosRepository.findDatosByIdDatos(id);
        if(resultado.isEmpty()){
            return null;
        }
        return datosMapper.toDto(resultado.get());
    }

    public DatosDto crearDatos(Datos datos) {

        Datos creado = datosRepository.save(datos);
        return datosMapper.toDto(creado);

    }

    public DatosDto actualizarDatos(int id, Datos datos) {
        Optional<Datos> busqueda = datosRepository.findDatosByIdDatos(id);

        if (busqueda.isPresent()) {
            Datos datosExistentes = busqueda.get();
            if (datos.getNombre() != null) {
                datosExistentes.setNombre(datos.getNombre());
            }
            if (datos.getApellidos() != null) {
                datosExistentes.setApellidos(datos.getApellidos());
            }
            if (datos.getFechaEdad() != null) {
                datosExistentes.setFechaEdad(datos.getFechaEdad());
            }
            if (datos.getDireccion() != null) {
                datosExistentes.setDireccion(datos.getDireccion());
            }

            Datos actualizados = datosRepository.save(datosExistentes);
            return datosMapper.toDto(actualizados);
        } else {
            return null;
        }
    }


    public void borrarDatos(int id) {

        datosRepository.deleteByIdDatos(id);

    }
}
