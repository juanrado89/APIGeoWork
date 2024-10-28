package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa",nullable = false)
    private int idEmpresa;

    @NotNull
    @OneToOne(mappedBy = "id_datos_empresa")
    private DatosEmpresa datosEmpresa;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdEmpresa());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Empresa empresa = (Empresa) obj;
        return idEmpresa == empresa.idEmpresa;
    }
}
