package services;

import dtos.CiudadDto;
import org.springframework.stereotype.Service;
import repositories.CiudadRepository;

import java.util.Optional;

@Service
public class CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }


    public CiudadDto buscarCiudadPorId(int id) {

        Optional<CiudadDto> resultado = ciudadRepository.findByIdCiudad(id);
        return resultado.orElseGet(null);

    }

    public CiudadDto buscarCiudadPorNombre(String nombre) {

        Optional<CiudadDto> resultado = ciudadRepository.findByCiudadContainsIgnoreCase(nombre);
        return resultado.orElseGet(null);

    }
}
