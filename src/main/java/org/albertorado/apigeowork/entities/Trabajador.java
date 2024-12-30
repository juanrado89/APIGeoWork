package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
public class Trabajador {

    public Trabajador(int idTrabajador, Datos datosUsuario, Experiencia datosExperiencia, PerfilUsuario perfilUsuario) {
        this.idTrabajador = idTrabajador;
        this.datosUsuario = datosUsuario;
        this.datosExperiencia = datosExperiencia;
        this.perfilUsuario = perfilUsuario;
    }

    public Trabajador() {
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public @NotNull Datos getDatosUsuario() {
        return datosUsuario;
    }

    public void setDatosUsuario(@NotNull Datos datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    public Experiencia getDatosExperiencia() {
        return datosExperiencia;
    }

    public void setDatosExperiencia(Experiencia datosExperiencia) {
        this.datosExperiencia = datosExperiencia;
    }

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

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
