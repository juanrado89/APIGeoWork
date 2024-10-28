package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class DatosDto {

    private int idDatos;
    private String nombre;
    private String apellidos;
    private Timestamp fechaEdad;
    private DireccionDto direccion;
}
