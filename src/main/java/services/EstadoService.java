package services;

import dtos.EstadoDto;
import org.springframework.stereotype.Service;
import repositories.EstadoRepository;

import java.util.Optional;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public EstadoDto getEstadoPorId(int id) {

        Optional<EstadoDto> resultado = estadoRepository.findByIdEstado(id);
        return resultado.orElseGet(null);

    }

    public EstadoDto getEstadoPorNombre(String nombre) {

        Optional<EstadoDto> resultado = estadoRepository.findByEstadoContainsIgnoreCase(nombre);
        return resultado.orElseGet(null);

    }
}
