package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.List;
import java.util.Objects;

@Entity

public class DatosEmpresa {

    public DatosEmpresa(int idDatosEmpresa, String nombreEmpresa, List<Sector> sector, Direccion direccion,
                        String contactoNombre, String contactoEmail, String contactoTelefono,
                        String sitioWeb, String fechaRegistro, Empresa empresa) {
        this.idDatosEmpresa = idDatosEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.sector = sector;
        this.direccion = direccion;
        this.contactoNombre = contactoNombre;
        this.contactoEmail = contactoEmail;
        this.contactoTelefono = contactoTelefono;
        this.sitioWeb = sitioWeb;
        this.fechaRegistro = fechaRegistro;
        this.empresa = empresa;
    }

    public DatosEmpresa() {
    }

    public int getIdDatosEmpresa() {
        return idDatosEmpresa;
    }

    public void setIdDatosEmpresa(int idDatosEmpresa) {
        this.idDatosEmpresa = idDatosEmpresa;
    }

    public @NotNull @Size(min = 0, max = 200) String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(@NotNull @Size(min = 0, max = 200) String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public @NotNull List<Sector> getSector() {
        return sector;
    }

    public void setSector(@NotNull List<Sector> sector) {
        this.sector = sector;
    }

    public @NotNull Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotNull Direccion direccion) {
        this.direccion = direccion;
    }

    public @NotNull @Size(min = 0, max = 255) String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(@NotNull @Size(min = 0, max = 255) String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public @NotNull @Size(min = 0, max = 255) @Email String getContactoEmail() {
        return contactoEmail;
    }

    public void setContactoEmail(@NotNull @Size(min = 0, max = 255) @Email String contactoEmail) {
        this.contactoEmail = contactoEmail;
    }

    public @NotNull @Digits(integer = 12, fraction = 0) String getContactoTelefono() {
        return contactoTelefono;
    }

    public void setContactoTelefono(@NotNull @Digits(integer = 12, fraction = 0) String contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }

    public @Size(min = 0, max = 255) String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(@Size(min = 0, max = 255) String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

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
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "datos_empresa_sector", joinColumns = @JoinColumn(name = "id_datos_empresa"), inverseJoinColumns = @JoinColumn(name = "id_sector"))
    private List<Sector> sector;

    @NotNull
    @ManyToOne(cascade = CascadeType.REMOVE)
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
    @Digits(integer = 9,fraction = 0)
    @Basic
    @Column(name = "contacto_telefono",precision = 12,nullable = false)
    private String contactoTelefono;

    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "sitio_web",length = 255,nullable = false)
    private String sitioWeb;

    @Basic
    @Column(name = "fecha_registro",length = 3000,nullable = false)
    private String fechaRegistro;

    @OneToOne(mappedBy = "datosEmpresa")
    private Empresa empresa;

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
