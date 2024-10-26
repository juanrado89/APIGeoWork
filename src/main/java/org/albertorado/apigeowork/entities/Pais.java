package org.albertorado.apigeowork.entities;

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
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais",nullable = false)
    private int idPais;

    @Basic
    @Column(name = "pais",nullable = false)
    private String pais;

    @OneToMany(mappedBy = "pais")
    private List<Direccion> direcciones;

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
