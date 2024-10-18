package services;

import dtos.DireccionDto;
import entities.Direccion;
import org.springframework.stereotype.Service;
import repositories.DireccionReposirory;

import java.util.Optional;
@Service
public class DireccionService {

    private final DireccionReposirory direccionReposirory;

    public DireccionService(DireccionReposirory direccionReposirory) {
        this.direccionReposirory = direccionReposirory;
    }


    public DireccionDto direccionPorId(int id) {
        Optional<DireccionDto> resultado = direccionReposirory.findDireccionByIdDireccion(id);
        return resultado.orElseGet(null);
    }

    public DireccionDto actualizarDireccion(int id, Direccion direccion){
        Optional<DireccionDto> busqueda = direccionReposirory.findDireccionByIdDireccion(id);
        if(busqueda.isPresent()){
            direccionReposirory.save(direccion);
            Optional<DireccionDto> resultado = direccionReposirory.findDireccionByIdDireccion(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }
    }

    public void borrarPorId(int id) {
        direccionReposirory.deleteDireccionByIdDireccion(id);
    }

    public DireccionDto crearDireccion(Direccion direccion) {
        Optional<DireccionDto> busqueda = direccionReposirory.findDireccionByDireccionContainsIgnoreCaseAndPisoAndPuertaContainsIgnoreCaseAndCodigoPostal(direccion.getDireccion(),direccion.getPiso(),direccion.getPuerta(),direccion.getCodigoPostal());
        if(busqueda.isPresent()){
            return null;
        }else{
            direccionReposirory.save(direccion);
            Optional<DireccionDto> resultado = direccionReposirory.findDireccionByDireccionContainsIgnoreCaseAndPisoAndPuertaContainsIgnoreCaseAndCodigoPostal(direccion.getDireccion(),direccion.getPiso(),direccion.getPuerta(),direccion.getCodigoPostal());
            return resultado.orElseGet(null);
        }
    }
}
