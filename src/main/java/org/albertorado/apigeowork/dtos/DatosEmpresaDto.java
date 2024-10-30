package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;
import org.albertorado.apigeowork.entities.Sector;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class DatosEmpresaDto {

    private int idDatosEmpresa;
    private String nombreEmpresa;
    private List<SectorDto> sector;
    private DireccionDto direccion;
    private String contactoNombre;
    private String contactoEmail;
    private String contactoTelefono;
    private String sitioWeb;
    private Timestamp fechaRegistro;
}
