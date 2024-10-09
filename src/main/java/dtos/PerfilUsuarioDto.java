package dtos;

import entities.Foto;
import entities.Trabajador;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

public interface PerfilUsuarioDto {

    int getIdPerfil();

    TrabajadorDto getIdTrabajador();

    String getEmail();

    FotoDto getFoto();
}
