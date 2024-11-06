package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity

public class Estado {

    public Estado(int idEstado, String estado, Pais pais, List<Ciudad> ciudades) {
        this.idEstado = idEstado;
        this.estado = estado;
        this.pais = pais;
        this.ciudades = ciudades;
    }

    public Estado() {
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public @NotNull @Size(min = 0, max = 120) String getEstado() {
        return estado;
    }

    public void setEstado(@NotNull @Size(min = 0, max = 120) String estado) {
        this.estado = estado;
    }

    public @NotNull Pais getPais() {
        return pais;
    }

    public void setPais(@NotNull Pais pais) {
        this.pais = pais;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado",nullable = false)
    private int idEstado;

    @NotNull
    @Size(min = 0,max = 120)
    @Basic
    @Column(name = "estado",length = 120,nullable = false)
    private String estado;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", nullable = false, updatable = false)
    private Pais pais;

    @OneToMany(mappedBy = "estado")
    private List<Ciudad> ciudades;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdEstado());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Estado estado = (Estado) obj;
        return idEstado == estado.idEstado;
    }
}
