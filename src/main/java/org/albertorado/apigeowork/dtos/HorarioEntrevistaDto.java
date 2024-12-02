package org.albertorado.apigeowork.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class HorarioEntrevistaDto {

    private int idHorario;

    private LocalDate dia;

    private LocalTime hora;

    private int candidatosDisponibles;

    private int candidatosAsignados;

    private List<TrabajadorDto> trabajadores;

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }


    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getCandidatosDisponibles() {
        return candidatosDisponibles;
    }

    public void setCandidatosDisponibles(int candidatosDisponibles) {
        this.candidatosDisponibles = candidatosDisponibles;
    }

    public int getCandidatosAsignados() {
        return candidatosAsignados;
    }

    public void setCandidatosAsignados(int candidatosAsignados) {
        this.candidatosAsignados = candidatosAsignados;
    }

    public List<TrabajadorDto> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<TrabajadorDto> trabajadores) {
        this.trabajadores = trabajadores;
    }
}
