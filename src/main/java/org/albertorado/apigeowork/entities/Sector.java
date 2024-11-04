package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Size(min = 1, max = 255)
    @Basic
    @Column(name = "sector",length = 255,nullable = false)
    private String sector;

    @OneToMany(mappedBy = "sector")
    private List<OfertaEmpleo> ofertas;

    @ManyToMany(mappedBy = "sector")
    private List<DatosEmpresa> datosEmpresas;

    @ManyToMany(mappedBy = "sector")
    private List<Experiencia> experiencias;

}
