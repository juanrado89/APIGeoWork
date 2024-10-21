package services;

import dtos.HorarioEntrevistaDto;
import entities.HorarioEntrevista;
import especificaciones.HorarioEntrevistaEspecificaciones;
import mapper.HorarioEntrevistaMapper;
import org.springframework.data.jpa.domain.Specification;
import repositories.HorarioEntrevistaRepository;

import java.util.List;
import java.util.Optional;

public class HorarioEntrevistaService {

    private final HorarioEntrevistaRepository horarioEntrevistaRepository;
    private final HorarioEntrevistaMapper horarioEntrevistaMapper;

    public HorarioEntrevistaService(HorarioEntrevistaRepository horarioEntrevistaRepository, HorarioEntrevistaMapper horarioEntrevistaMapper) {
        this.horarioEntrevistaRepository = horarioEntrevistaRepository;
        this.horarioEntrevistaMapper = horarioEntrevistaMapper;
    }

    public HorarioEntrevistaDto buscarPorId(int id) {
        Optional<HorarioEntrevistaDto> oferta = horarioEntrevistaRepository.findByIdHorario(id);
        return oferta.orElseGet(null);
    }

    public List<HorarioEntrevistaDto> buscarPorIdOferta(int id) {
        return horarioEntrevistaRepository.findAllByOfertaEmpleo_IdOferta(id);
    }

    public HorarioEntrevistaDto crearHorarioEntrevista(HorarioEntrevista horarioEntrevista) {
        HorarioEntrevista creado = horarioEntrevistaRepository.save(horarioEntrevista);
        return horarioEntrevistaMapper.toDto(creado);
    }

    public List<HorarioEntrevistaDto> crearHorariosEntrevista(List<HorarioEntrevista> horariosEntrevista) {
        List<HorarioEntrevista> creado = horarioEntrevistaRepository.saveAll(horariosEntrevista);
        return horarioEntrevistaMapper.toDto(creado);
    }

    public HorarioEntrevistaDto actualizarHorario(int id, HorarioEntrevista horarioEntrevista) {
        Optional<HorarioEntrevistaDto> busqueda = horarioEntrevistaRepository.findByIdHorario(id);
        if(busqueda.isPresent()){
            horarioEntrevistaRepository.save(horarioEntrevista);
            Optional<HorarioEntrevistaDto> resultado = horarioEntrevistaRepository.findByIdHorario(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }
    }

    public void borrarHorario(int id) {
        horarioEntrevistaRepository.deleteById(id);
    }

    public List<HorarioEntrevistaDto> buscarPorParametros(HorarioEntrevista parametros) {
        Specification<HorarioEntrevista> especificaciones = Specification.where(
                HorarioEntrevistaEspecificaciones.tieneIdOferta(parametros.getOfertaEmpleo().getIdOferta())
                .and(HorarioEntrevistaEspecificaciones.tieneDia(parametros.getDia())
                        .and(HorarioEntrevistaEspecificaciones.tieneHora(parametros.getHora()))
                        .and(HorarioEntrevistaEspecificaciones.tieneDisponibilidad())));
        List<HorarioEntrevista> resultado = horarioEntrevistaRepository.findAll(especificaciones);
        return horarioEntrevistaMapper.toDto(resultado);
    }
}
