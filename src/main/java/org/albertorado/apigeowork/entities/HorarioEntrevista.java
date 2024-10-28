package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HorarioEntrevista {

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

    @ManyToMany
    @JoinTable(name = "trabajador_horario", joinColumns = @JoinColumn(name = "horario_id"), inverseJoinColumns = @JoinColumn(name = "trabajador_id"))
    private List<Trabajador> trabajadores;

}
