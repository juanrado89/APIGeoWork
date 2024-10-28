package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
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
public class Ciudad {

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
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad", nullable = false, updatable = false)
    private Estado estado;

    @OneToMany(mappedBy = "ciudad")
    private List<Direccion> direcciones;



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
