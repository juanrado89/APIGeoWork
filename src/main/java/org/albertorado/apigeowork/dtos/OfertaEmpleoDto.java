package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class OfertaEmpleoDto {

    private int idOferta;
    private EmpresaDto empresa;
    private String titulo;
    private int cantidad;
    private String descripcion;
    private SectorDto sector;
    private String requisitos;
    private NivelEducativoDto nivelEducativo;
    private float salarioMin;
    private float salarioMax;
    private DireccionDto direccion;
    private Timestamp fechaPublicacion;
    private int estado;

}
