package org.albertorado.apigeowork.dtos;

import java.util.List;

public interface PerfilEmpresaDto {

    int getIdUsuario();

    EmpresaDto getIdEmpresa();

    String getEmail();

    List<OfertaEmpleoDto> getOfertas();
}
