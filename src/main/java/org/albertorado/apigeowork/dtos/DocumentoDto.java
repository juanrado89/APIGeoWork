package org.albertorado.apigeowork.dtos;

public interface DocumentoDto {

    Long getIdDocumento();
    String getNombre();
    String getTipoContenido();
    byte[] getContenido();
}
