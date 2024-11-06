package org.albertorado.apigeowork.dtos;

import java.util.List;

public class ExperienciaTotalDto {

    private int idExperienciaTotal;
    private List<DescripcionExperienciaDto> descripcionExperiencia;

    public int getIdExperienciaTotal() {
        return idExperienciaTotal;
    }

    public void setIdExperienciaTotal(int idExperienciaTotal) {
        this.idExperienciaTotal = idExperienciaTotal;
    }

    public List<DescripcionExperienciaDto> getDescripcionExperiencia() {
        return descripcionExperiencia;
    }

    public void setDescripcionExperiencia(List<DescripcionExperienciaDto> descripcionExperiencia) {
        this.descripcionExperiencia = descripcionExperiencia;
    }
}
