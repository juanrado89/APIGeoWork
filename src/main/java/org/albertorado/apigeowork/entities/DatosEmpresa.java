package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
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

    @NotNull
    @Size(min = 0,max = 200)
    @Basic
    @Column(name = "nombre_empresa",length = 200,nullable = false)
    private String nombreEmpresa;

    @NotNull
    @ManyToMany(mappedBy = "datosEmpresa")
    private List<Sector> sector;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false, updatable = false)
    private Direccion direccion;

    @NotNull
    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "contacto_nombre",length = 255,nullable = false)
    private String contactoNombre;

    @NotNull
    @Size(min = 0,max = 255)
    @Email
    @Basic
    @Column(name = "contacto_email",length = 255,nullable = false)
    private String contactoEmail;

    @NotNull
    @Digits(integer = 12,fraction = 0)
    @Basic
    @Column(name = "contacto_telefono",precision = 12,nullable = false)
    private String contactoTelefono;

    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "sitio_web",length = 255,nullable = false)
    private String sitioWeb;

    @Basic
    @Column(name = "fecha_registro",nullable = false)
    private Timestamp fechaRegistro;

    @NotNull
    @Digits(integer = 1,fraction = 0)
    @Basic
    @Column(name = "estado",precision = 1,nullable = false)
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
