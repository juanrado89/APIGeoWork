package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.DireccionDto;
import org.albertorado.apigeowork.entities.Direccion;
import org.albertorado.apigeowork.mapper.DireccionMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.DireccionReposirory;

import java.util.Optional;
@Service
public class DireccionService {

    private final DireccionReposirory direccionReposirory;
    private final DireccionMapper direccionMapper;

    public DireccionService(DireccionReposirory direccionReposirory, DireccionMapper direccionMapper) {
        this.direccionReposirory = direccionReposirory;
        this.direccionMapper = direccionMapper;
    }


    public DireccionDto direccionPorId(int id) {
        Optional<Direccion> resultado = direccionReposirory.findDireccionByIdDireccion(id);
        if(resultado.isEmpty()){
            return null;
        }
        return direccionMapper.toDto(resultado.get());
    }

    public DireccionDto actualizarDireccion(int id, Direccion direccion) {
        Optional<Direccion> busqueda = direccionReposirory.findDireccionByIdDireccion(id);

        if (busqueda.isPresent()) {
            Direccion direccionExistente = busqueda.get();

            if (direccion.getDireccion() != null) {
                direccionExistente.setDireccion(direccion.getDireccion());
            }
            if (direccion.getPiso() != -1) {
                direccionExistente.setPiso(direccion.getPiso());
            }
            if (direccion.getPuerta() != null) {
                direccionExistente.setPuerta(direccion.getPuerta());
            }
            if (direccion.getCodigoPostal() != 0) {
                direccionExistente.setCodigoPostal(direccion.getCodigoPostal());
            }
            if (direccion.getCiudad() != null) {
                direccionExistente.setCiudad(direccion.getCiudad());
            }
            Direccion actualizada = direccionReposirory.save(direccionExistente);
            return direccionMapper.toDto(actualizada);
        } else {
            return null;
        }
    }


    public void borrarPorId(int id) {
        direccionReposirory.deleteDireccionByIdDireccion(id);
    }

    public DireccionDto crearDireccion(Direccion direccion) {
        Direccion creada = direccionReposirory.save(direccion);
        return direccionMapper.toDto(creada);
    }
}
