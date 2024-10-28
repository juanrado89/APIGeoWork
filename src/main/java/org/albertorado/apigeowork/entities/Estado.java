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
public class Estado {

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
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false, updatable = false)
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
