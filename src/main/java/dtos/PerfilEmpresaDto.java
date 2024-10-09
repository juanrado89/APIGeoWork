package dtos;

import entities.Empresa;
import entities.OfertaEmpleo;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

public interface PerfilEmpresaDto {

    int getIdUsuario();

    EmpresaDto getIdEmpresa();

    String getEmail();

    List<OfertaEmpleoDto> getOfertas();
}
