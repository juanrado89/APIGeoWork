package org.albertorado.apigeowork.dtos;


import java.util.List;

public class DatosEmpresaDto {

    private int idDatosEmpresa;
    private String nombreEmpresa;
    private List<SectorDto> sector;
    private DireccionDto direccion;
    private String contactoNombre;
    private String contactoEmail;
    private String contactoTelefono;
    private String sitioWeb;
    private String fechaRegistro;

    public int getIdDatosEmpresa() {
        return idDatosEmpresa;
    }

    public void setIdDatosEmpresa(int idDatosEmpresa) {
        this.idDatosEmpresa = idDatosEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public List<SectorDto> getSector() {
        return sector;
    }

    public void setSector(List<SectorDto> sector) {
        this.sector = sector;
    }

    public DireccionDto getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDto direccion) {
        this.direccion = direccion;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public String getContactoEmail() {
        return contactoEmail;
    }

    public void setContactoEmail(String contactoEmail) {
        this.contactoEmail = contactoEmail;
    }

    public String getContactoTelefono() {
        return contactoTelefono;
    }

    public void setContactoTelefono(String contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
