package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
public class Pais {

    public Pais(int idPais, String pais, List<Estado> estados) {
        this.idPais = idPais;
        this.pais = pais;
        this.estados = estados;
    }

    public Pais() {
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public @NotNull @Size(min = 2, max = 120) String getPais() {
        return pais;
    }

    public void setPais(@NotNull @Size(min = 2, max = 120) String pais) {
        this.pais = pais;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais",nullable = false)
    private int idPais;

    @Basic
    @NotNull
    @Size(min = 2,max = 120)
    @Column(name = "pais",length = 120,nullable = false)
    private String pais;


    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;




    @Override
    public int hashCode() {
        return Objects.hashCode(getIdPais());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pais pais = (Pais) obj;
        return idPais == pais.idPais;
    }
}
