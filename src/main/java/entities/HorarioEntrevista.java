package entities;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "id_oferta", referencedColumnName = "id_pais", nullable = true,updatable = false)  // Referencia a la oferta de empleo
    private OfertaEmpleo ofertaEmpleo;

    @Basic
    @Column(name = "dia", nullable = false)
    private LocalDate dia;  // Fecha del horario

    @Basic
    @Column(name = "hora", nullable = false)
    private LocalTime hora;  // Hora específica

    @Basic
    @Column(name = "candidatos_disponibles", nullable = false)
    private int candidatosDisponibles;

    @Basic
    @Column(name = "candidatos_asignados", nullable = false)
    private int candidatosAsignados;

    @ManyToMany
    @JoinTable(
            name = "trabajador_horario",  // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "horario_id"),  // Columna que referencia a HorarioEntrevista
            inverseJoinColumns = @JoinColumn(name = "trabajador_id")  // Columna que referencia a Trabajador
    )
    private List<Trabajador> trabajadores;

    // Método para verificar si hay disponibilidad para más candidatos
    public boolean hayDisponibilidad() {
        return candidatosAsignados < candidatosDisponibles;
    }

    public void asignarCandidato() {
        if (hayDisponibilidad()) {
            this.candidatosAsignados++;
        }
    }
}
