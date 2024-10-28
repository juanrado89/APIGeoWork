package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TrabajadorDto {

    private int idTrabajador;

    private DatosDto datosUsuario;

    private ExperienciaDto datosExperiencia;

}
