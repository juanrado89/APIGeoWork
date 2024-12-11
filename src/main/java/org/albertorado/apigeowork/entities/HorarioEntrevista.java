package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

@Entity
public class HorarioEntrevista {

    public HorarioEntrevista(int idHorario, OfertaEmpleo ofertaEmpleo, LocalDate dia, LocalTime hora, int candidatosDisponibles, int candidatosAsignados, List<PerfilUsuario> trabajadores) {
        this.idHorario = idHorario;
        this.ofertaEmpleo = ofertaEmpleo;
        this.dia = dia;
        this.hora = hora;
        this.candidatosDisponibles = candidatosDisponibles;
        this.candidatosAsignados = candidatosAsignados;
        this.trabajadores = trabajadores;
    }

    public HorarioEntrevista() {
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public @NotNull OfertaEmpleo getOfertaEmpleo() {
        return ofertaEmpleo;
    }

    public void setOfertaEmpleo(@NotNull OfertaEmpleo ofertaEmpleo) {
        this.ofertaEmpleo = ofertaEmpleo;
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

    @NotNull
    @Digits(integer = 3, fraction = 0)
    public int getCandidatosDisponibles() {
        return candidatosDisponibles;
    }

    public void setCandidatosDisponibles(@NotNull @Digits(integer = 3, fraction = 0) int candidatosDisponibles) {
        this.candidatosDisponibles = candidatosDisponibles;
    }

    @NotNull
    @Digits(integer = 3, fraction = 0)
    public int getCandidatosAsignados() {
        return candidatosAsignados;
    }

    public void setCandidatosAsignados(@NotNull @Digits(integer = 3, fraction = 0) int candidatosAsignados) {
        this.candidatosAsignados = candidatosAsignados;
    }

    public List<PerfilUsuario> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<PerfilUsuario> trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario", nullable = false)
    private int idHorario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_oferta", referencedColumnName = "id_oferta", nullable = true,updatable = false)
    private OfertaEmpleo ofertaEmpleo;

    @Basic
    @Column(name = "dia", nullable = false)
    private LocalDate dia;

    @Basic
    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @NotNull
    @Digits(integer = 3,fraction = 0)
    @Basic
    @Column(name = "candidatos_disponibles",precision = 3, nullable = false)
    private int candidatosDisponibles;

    @NotNull
    @Digits(integer = 3,fraction = 0)
    @Basic
    @Column(name = "candidatos_asignados",precision = 3, nullable = false)
    private int candidatosAsignados;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "usuario_horario", joinColumns = @JoinColumn(name = "horario_id"), inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private List<PerfilUsuario> trabajadores;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdHorario());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HorarioEntrevista horario = (HorarioEntrevista) obj;
        return idHorario == horario.idHorario;
    }

}
