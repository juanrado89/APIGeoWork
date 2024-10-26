package org.albertorado.apigeowork.dtos;

import java.util.List;

public interface TrabajadorDto {
    int getIdTrabajador();

    DatosDto GetDatosUsuario();

    ExperienciaDto GetDatosExperiencia();

    List<HorarioEntrevistaDto> getHorarios();
}
