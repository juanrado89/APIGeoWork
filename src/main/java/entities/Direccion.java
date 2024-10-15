package entities;

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
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion",nullable = false)
    private int idDireccion;

    @Basic
    @Column(name = "direccion_texto",nullable = false)
    private String direccion;

    @ManyToOne()
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false, updatable = false)
    private Ciudad ciudad;

    @Basic
    @Column(name = "codigo_postal",nullable = false)
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
