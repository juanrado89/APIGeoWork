package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilUsuarioPDto {

    private int idPerfil;

    private String password;

    private TrabajadorDto idTrabajador;

    private String email;

    private FotoDto foto;
}
