package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotoDto {
    private Long idFoto;
    private String nombre;
    private String tipoContenido;
    private byte[] datos;

}
