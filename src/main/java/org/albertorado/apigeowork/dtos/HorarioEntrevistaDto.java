package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class HorarioEntrevistaDto {

    private int idHorario;

    private OfertaEmpleoDto ofertaEmpleo;

    private LocalDate dia;

    private LocalTime hora;

    private int candidatosDisponibles;

    private int candidatosAsignados;

    private List<TrabajadorDto> trabajadores;
}
