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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_trabajador",nullable = false)
    private idDatos;

    @Basic
    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Basic
    @Column(name = "apellidos",nullable = false)
    private String apellidos;

    @Basic
    @Column(name = "fecha_edad",nullable = false)
    private Timestamp fechaEdad;

    private Direccion direccion;

}
