package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CiudadDto {

    private int idCiudad;
    private String ciudad;
    private EstadoDto estado;

}
