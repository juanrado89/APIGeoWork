package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.sql.Timestamp;
import java.util.Objects;

@Entity

public class Datos {

    public Datos(String nombre, int idDatos, String apellidos, Timestamp fechaEdad, Direccion direccion, Trabajador trabajador) {
        this.nombre = nombre;
        this.idDatos = idDatos;
        this.apellidos = apellidos;
        this.fechaEdad = fechaEdad;
        this.direccion = direccion;
        this.trabajador = trabajador;
    }

    public Datos() {
    }

    public int getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(int idDatos) {
        this.idDatos = idDatos;
    }

    public @NotNull @Size(min = 0, max = 120) String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull @Size(min = 0, max = 120) String nombre) {
        this.nombre = nombre;
    }

    public @NotNull @Size(min = 0, max = 200) String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NotNull @Size(min = 0, max = 200) String apellidos) {
        this.apellidos = apellidos;
    }

    public @NotNull Timestamp getFechaEdad() {
        return fechaEdad;
    }

    public void setFechaEdad(@NotNull Timestamp fechaEdad) {
        this.fechaEdad = fechaEdad;
    }

    public @NotNull Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotNull Direccion direccion) {
        this.direccion = direccion;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_datos",nullable = false)
    private int idDatos;

    @NotNull
    @Size(min = 0,max = 120)
    @Basic
    @Column(name = "nombre",length = 120,nullable = false)
    private String nombre;

    @NotNull
    @Size(min = 0,max = 200)
    @Basic
    @Column(name = "apellidos",length = 200,nullable = false)
    private String apellidos;

    @NotNull
    @Basic
    @Column(name = "fecha_edad",nullable = false)
    private Timestamp fechaEdad;

    @NotNull
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false, updatable = false)
    private Direccion direccion;

    @OneToOne(mappedBy = "datosUsuario")
    private Trabajador trabajador;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdDatos());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Datos datos = (Datos) obj;
        return idDatos == datos.idDatos;
    }

}
