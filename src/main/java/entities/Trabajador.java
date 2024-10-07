package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajador",nullable = false)
    private int idTrabajador;

    @OneToOne(mappedBy = "id_datos")
    private Datos datosUsuario;

    @OneToOne(mappedBy = "id_experiencia")
    private Experiencia datosExperiencia;

    @ManyToMany(mappedBy = "trabajadores")
    private List<HorarioEntrevista> horarios;
    @Override
    public int hashCode() {
        return Objects.hashCode(getIdTrabajador());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Trabajador trabajador = (Trabajador) obj;
        return idTrabajador == trabajador.idTrabajador;
    }
}
