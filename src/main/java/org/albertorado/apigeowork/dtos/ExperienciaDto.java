package org.albertorado.apigeowork.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class ExperienciaDto {

    private int idExperiencia;

    private NivelEducativoDto nivelEducativo;

    private List<SectorDto> sector;

    private ExperienciaTotalDto experienciaTotal;

    private DocumentoDto cvUrl;

    private Timestamp fechaRegistro;

}
