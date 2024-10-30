package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDto {

    private int idEstado;
    private String estado;
    private PaisDto pais;
}
