package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_datos", referencedColumnName = "id_datos")
    private Datos datosUsuario;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_experiencia", referencedColumnName = "id_experiencia")
    private Experiencia datosExperiencia;

    @ManyToMany(mappedBy = "trabajadores")
    private List<HorarioEntrevista> horarios;

    @OneToOne(mappedBy = "trabajador")
    private PerfilUsuario perfilUsuario;

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
