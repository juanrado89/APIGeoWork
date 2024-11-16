package org.albertorado.apigeowork.dtos;

import java.sql.Timestamp;
public class DatosDto {

    private int idDatos;
    private String nombre;
    private String apellidos;
    private int telefono;
    private Timestamp fechaEdad;
    private DireccionDto direccion;

    public int getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(int idDatos) {
        this.idDatos = idDatos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Timestamp getFechaEdad() {
        return fechaEdad;
    }

    public void setFechaEdad(Timestamp fechaEdad) {
        this.fechaEdad = fechaEdad;
    }

    public DireccionDto getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDto direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
