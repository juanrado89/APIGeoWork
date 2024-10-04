package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

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

    @OneToOne(mappedBy = "idDatos")
    private Trabajador trabajador;

    @ManyToOne()
    @JoinColumn(name = "id_datos", referencedColumnName = "id_datos", nullable = false, updatable = false)
    private Direccion direccion;

}
