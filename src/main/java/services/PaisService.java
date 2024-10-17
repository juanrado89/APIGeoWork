package services;

import dtos.PaisDto;
import org.springframework.stereotype.Service;
import repositories.PaisRepository;

import java.util.Optional;
@Service
public class PaisService {

    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public PaisDto getPaisPorId(int id) {

        Optional<PaisDto> resultado = paisRepository.findAllByIdPais(id);
        return resultado.orElseGet(null);

    }

    public PaisDto getPaisPorNombre(String nombre) {

        Optional<PaisDto> resultado = paisRepository.findAllByPaisContainsIgnoreCase(nombre);
        return resultado.orElseGet(null);

    }
}
