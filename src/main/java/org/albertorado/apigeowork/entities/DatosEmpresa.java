package org.albertorado.apigeowork.entities;

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
public class DatosEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_datos_empresa",nullable = false)
    private int idDatosEmpresa;

    @Basic
    @Column(name = "nombre_empresa",nullable = false)
    private String nombreEmpresa;

    @Basic
    @Column(name = "sector",nullable = false)
    private String sector;

    @ManyToOne()
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false, updatable = false)
    private Direccion direccion;

    @Basic
    @Column(name = "contacto_nombre",nullable = false)
    private String contactoNombre;

    @Basic
    @Column(name = "contacto_email",nullable = false)
    private String contactoEmail;

    @Basic
    @Column(name = "contacto_telefono",nullable = false)
    private String contactoTelefono;

    @Basic
    @Column(name = "sitio_web",nullable = false)
    private String sitioWeb;

    @Basic
    @Column(name = "fecha_registro",nullable = false)
    private Timestamp fechaRegistro;

    @Basic
    @Column(name = "estado",nullable = false)
    private int estado;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdDatosEmpresa());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DatosEmpresa datos = (DatosEmpresa) obj;
        return idDatosEmpresa == datos.idDatosEmpresa;
    }

}
