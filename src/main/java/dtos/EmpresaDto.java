package dtos;

import entities.DatosEmpresa;
import jakarta.persistence.OneToOne;

public interface EmpresaDto {

    int getIdEmpresa();
    DatosEmpresaDto getDatosEmpresa();

}
