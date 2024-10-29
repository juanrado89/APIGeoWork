package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PerfilEmpresaPDto {

    private int idUsuario;

    private String password;

    private EmpresaDto idEmpresa;

    private String email;

    private List<SectorDto> sector;
}
