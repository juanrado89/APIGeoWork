package org.albertorado.apigeowork.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    public String getHora() {
        if (this.hora != null) {
            return this.hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
        return null;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setHora(String hora) {
        try {
            this.hora = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm:ss"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("El formato de la hora no es válido. Se espera 'HH:mm:ss'.", e);
        }
    }

    // Métodos existentes para 'dia'

    public String getDia() {
        if (this.dia != null) {
            return this.dia.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return null;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public void setDia(String dia) {
        try {
            this.dia = LocalDate.parse(dia, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("El formato de la fecha no es válido. Se espera 'dd/MM/yyyy'.", e);
        }
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
