package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
public class Trabajador {

    public Trabajador(int idTrabajador, Datos datosUsuario, Experiencia datosExperiencia, List<HorarioEntrevista> horarios, PerfilUsuario perfilUsuario) {
        this.idTrabajador = idTrabajador;
        this.datosUsuario = datosUsuario;
        this.datosExperiencia = datosExperiencia;
        this.horarios = horarios;
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

    public List<HorarioEntrevista> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioEntrevista> horarios) {
        this.horarios = horarios;
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
