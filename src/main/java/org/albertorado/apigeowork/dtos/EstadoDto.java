package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDto {

    private int dEstado;
    private String estado;
    private PaisDto pais;
}
