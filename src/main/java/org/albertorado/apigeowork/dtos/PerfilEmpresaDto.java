package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PerfilEmpresaDto {

    private int idUsuario;
    private EmpresaDto empresa;
    private List<SectorDto> sector;
    private String email;
    private FotoDto foto;


}
