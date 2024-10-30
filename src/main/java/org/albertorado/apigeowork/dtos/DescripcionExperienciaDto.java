package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class DescripcionExperienciaDto {

    private int idDescripcionExperiencia;
    private String nombreEmpresa;
    private String descripcion;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
}
