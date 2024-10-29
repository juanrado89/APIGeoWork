package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoDto {

    private Long idDocumento;
    private String nombre;
    private String tipoContenido;
    private byte[] contenido;
}
