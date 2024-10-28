package org.albertorado.apigeowork.dtos;

import java.util.List;

public interface PerfilEmpresaPDto {

    int getIdUsuario();

    String getPassword();

    EmpresaDto getIdEmpresa();

    String getEmail();

    List<SectorDto> getSector();
}
