package dtos;

import entities.Direccion;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

public interface DatosEmpresaDto {

    int getIdDatosEmpresa();
    String getNombreEmpresa();
    String getSector();
    DireccionDto getDireccion();
    String getContactoNombre();
    String getContactoEmail();
    String getContactoTelefono();
    String getSitioWeb();
    Timestamp getFechaRegistro();
    int getEstado();
}
