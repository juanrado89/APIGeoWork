package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Datos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_datos",nullable = false)
    private int idDatos;

    @Basic
    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Basic
    @Column(name = "apellidos",nullable = false)
    private String apellidos;

    @Basic
    @Column(name = "fecha_edad",nullable = false)
    private Timestamp fechaEdad;

    @ManyToOne()
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false, updatable = false)
    private Direccion direccion;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdDatos());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Datos datos = (Datos) obj;
        return idDatos == datos.idDatos;
    }

}
