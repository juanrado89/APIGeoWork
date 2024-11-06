package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;


@Entity

public class Direccion {

    public Direccion(int idDireccion, String direccion, int piso, String puerta, Ciudad ciudad, int codigoPostal, List<Datos> datos, List<OfertaEmpleo> ofertas) {
        this.idDireccion = idDireccion;
        this.direccion = direccion;
        this.piso = piso;
        this.puerta = puerta;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.datos = datos;
        this.ofertas = ofertas;
    }

    public Direccion() {
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public @NotNull @Size(min = 0, max = 255) String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotNull @Size(min = 0, max = 255) String direccion) {
        this.direccion = direccion;
    }

    @NotNull
    @Digits(integer = 3, fraction = 0)
    public int getPiso() {
        return piso;
    }

    public void setPiso(@NotNull @Digits(integer = 3, fraction = 0) int piso) {
        this.piso = piso;
    }

    public @NotNull @Size(min = 0, max = 50) String getPuerta() {
        return puerta;
    }

    public void setPuerta(@NotNull @Size(min = 0, max = 50) String puerta) {
        this.puerta = puerta;
    }

    public @NotNull Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(@NotNull Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @NotNull
    @Digits(integer = 9, fraction = 0)
    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(@NotNull @Digits(integer = 9, fraction = 0) int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public List<Datos> getDatos() {
        return datos;
    }

    public void setDatos(List<Datos> datos) {
        this.datos = datos;
    }

    public List<OfertaEmpleo> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<OfertaEmpleo> ofertas) {
        this.ofertas = ofertas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion",nullable = false)
    private int idDireccion;

    @NotNull
    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "direccion_texto",length = 255,nullable = false)
    private String direccion;

    @NotNull
    @Digits(integer = 3,fraction = 0)
    @Basic
    @Column(name = "piso",precision = 3,nullable = false)
    private int piso;

    @NotNull
    @Size(min = 0,max = 50)
    @Basic
    @Column(name = "puerta",length = 50,nullable = false)
    private String puerta;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad", nullable = false, updatable = false)
    private Ciudad ciudad;

    @NotNull
    @Digits(integer = 9,fraction = 0)
    @Basic
    @Column(name = "codigo_postal",precision = 9,nullable = false)
    private int codigoPostal;


    @OneToMany(mappedBy = "direccion")
    private List<Datos> datos;

    @OneToMany(mappedBy = "direccion")
    private List<OfertaEmpleo> ofertas;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdDireccion());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Direccion direccion1 = (Direccion) obj;
        return idDireccion == direccion1.idDireccion;
    }

}
