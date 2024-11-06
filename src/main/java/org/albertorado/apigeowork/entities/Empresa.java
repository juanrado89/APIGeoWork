package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity

public class Empresa {

    public Empresa(int idEmpresa, DatosEmpresa datosEmpresa, PerfilEmpresa perfilEmpresa, List<OfertaEmpleo> ofertas) {
        this.idEmpresa = idEmpresa;
        this.datosEmpresa = datosEmpresa;
        this.perfilEmpresa = perfilEmpresa;
        this.ofertas = ofertas;
    }

    public Empresa() {
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public @NotNull DatosEmpresa getDatosEmpresa() {
        return datosEmpresa;
    }

    public void setDatosEmpresa(@NotNull DatosEmpresa datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }

    public PerfilEmpresa getPerfilEmpresa() {
        return perfilEmpresa;
    }

    public void setPerfilEmpresa(PerfilEmpresa perfilEmpresa) {
        this.perfilEmpresa = perfilEmpresa;
    }

    public List<OfertaEmpleo> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<OfertaEmpleo> ofertas) {
        this.ofertas = ofertas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa",nullable = false)
    private int idEmpresa;

    @NotNull
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_datos_empresa", referencedColumnName = "id_datos_empresa")
    private DatosEmpresa datosEmpresa;

    @OneToOne(mappedBy = "empresa")
    private PerfilEmpresa perfilEmpresa;

    @OneToMany(mappedBy = "empresa")
    private List<OfertaEmpleo> ofertas;

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
