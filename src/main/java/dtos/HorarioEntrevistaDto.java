package dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface HorarioEntrevistaDto {

    int getIdHorario();

    OfertaEmpleoDto getOfertaEmpleo();

    LocalDate getDia();  // Fecha del horario

    LocalTime getHora();  // Hora específica

    int getCandidatosDisponibles();

    int getCandidatosAsignados();

    List<TrabajadorDto> getTrabajadores();
}
