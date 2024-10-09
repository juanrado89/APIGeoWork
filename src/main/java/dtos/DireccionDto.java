package dtos;

import entities.Pais;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;

public interface DireccionDto {

    int getIdDireccion();

    String getDireccion();

    String getCiudad();
    int getCodigoPostal();
    PaisDto getPais();

}
