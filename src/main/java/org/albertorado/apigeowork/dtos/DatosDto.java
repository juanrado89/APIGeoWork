package org.albertorado.apigeowork.dtos;

import java.sql.Timestamp;

public interface DatosDto {

    int getIdDatos();
    String getNombre();
    String getApellidos();
    Timestamp getFechaEdad();
    DireccionDto getDireccion();
}
