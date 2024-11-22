package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
public class Sector {

    public Sector(int idSector, String sector, List<OfertaEmpleo> ofertas, List<DatosEmpresa> datosEmpresas, List<Experiencia> experiencias) {
        this.idSector = idSector;
        this.sector = sector;
        this.ofertas = ofertas;
        this.datosEmpresas = datosEmpresas;
        this.experiencias = experiencias;
    }

    public Sector() {
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public @NotNull @Size(min = 1, max = 255) String getSector() {
        return sector;
    }

    public void setSector(@NotNull @Size(min = 1, max = 255) String sector) {
        this.sector = sector;
    }

    public List<OfertaEmpleo> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<OfertaEmpleo> ofertas) {
        this.ofertas = ofertas;
    }

    public List<DatosEmpresa> getDatosEmpresas() {
        return datosEmpresas;
    }

    public void setDatosEmpresas(List<DatosEmpresa> datosEmpresas) {
        this.datosEmpresas = datosEmpresas;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

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

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdSector());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sector sector1 = (Sector) obj;
        return idSector == sector1.idSector;
    }
}
