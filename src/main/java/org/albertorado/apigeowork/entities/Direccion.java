package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class Direccion {

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
