package services;

import dtos.DireccionDto;
import entities.Direccion;
import mapper.DireccionMapper;
import org.springframework.stereotype.Service;
import repositories.DireccionReposirory;

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
        Direccion creada = direccionReposirory.save(direccion);
        return direccionMapper.toDto(creada);
    }
}
