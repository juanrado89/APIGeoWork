package org.albertorado.apigeowork.dtos;

import java.sql.Timestamp;

public interface DescripcionExperienciaDto {

    public int getIdDescripcionExperiencia();
    public String getNombreEmpresa();
    public String getDescripcion();
    public Timestamp getFechaInicio();
    public Timestamp getFechaFin();
}
