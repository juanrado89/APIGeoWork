package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExperienciaTotalDto {

    private int idExperienciaTotal;
    private List<DescripcionExperienciaDto> descripcionExperiencia;
}
