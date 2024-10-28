package org.albertorado.apigeowork.dtos;

import java.util.List;

public interface PerfilEmpresaDto {

    int getIdUsuario();

    EmpresaDto getIdEmpresa();

    List<SectorDto> getSector();

    String getEmail();


}
