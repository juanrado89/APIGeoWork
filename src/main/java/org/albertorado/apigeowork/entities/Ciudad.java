package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
public class Ciudad {
    public Ciudad() {
    }

    public Ciudad(int idCiudad, String ciudad, Estado estado, List<Direccion> direcciones) {
        this.idCiudad = idCiudad;
        this.ciudad = ciudad;
        this.estado = estado;
        this.direcciones = direcciones;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad",nullable = false)
    private int idCiudad;

    @NotNull
    @Size(min = 0,max = 100)
    @Basic
    @Column(name = "ciudad",length = 100,nullable = false)
    private String ciudad;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false, updatable = false)
    private Estado estado;

    @OneToMany(mappedBy = "ciudad")
    private List<Direccion> direcciones;

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public @NotNull @Size(min = 0, max = 100) String getCiudad() {
        return ciudad;
    }

    public void setCiudad(@NotNull @Size(min = 0, max = 100) String ciudad) {
        this.ciudad = ciudad;
    }

    public @NotNull Estado getEstado() {
        return estado;
    }

    public void setEstado(@NotNull Estado estado) {
        this.estado = estado;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdCiudad());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ciudad ciudad = (Ciudad) obj;
        return idCiudad == ciudad.idCiudad;
    }
}
