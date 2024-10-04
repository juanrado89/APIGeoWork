package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @Basic
    @Column(name = "direccion_texto",nullable = false)
    private String direccion;

    @Basic
    @Column(name = "ciudad",nullable = false)
    private String ciudad;

    @Basic
    @Column(name = "pais",nullable = false)
    private String pais;

    @OneToMany(mappedBy = "direccion")
    private List<Datos> datos;

}
