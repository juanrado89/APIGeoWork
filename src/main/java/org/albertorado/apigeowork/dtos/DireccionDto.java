package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DireccionDto {

    private int idDireccion;
    private String direccion;
    private int piso;
    private String puerta;
    private CiudadDto ciudad;
    private int codigoPostal;


}
