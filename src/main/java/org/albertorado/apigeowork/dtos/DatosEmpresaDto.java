package org.albertorado.apigeowork.dtos;

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
