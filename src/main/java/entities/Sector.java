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
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sector",nullable = false)
    private int idSector;

    @Basic
    @Column(name = "sector",nullable = false)
    private String sector;

    @OneToMany(mappedBy = "sector")
    private List<OfertaEmpleo> ofertas;
}
