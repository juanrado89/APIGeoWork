package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class NivelEducativoDto {

    private int idNivelEducativo;
    private String tituloNivelEducativo;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private NivelDto nivel;
}
