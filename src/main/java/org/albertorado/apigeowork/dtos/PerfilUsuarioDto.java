package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilUsuarioDto {

    private int idPerfil;

    private TrabajadorDto idTrabajador;

    private String email;

    private FotoDto foto;
}
