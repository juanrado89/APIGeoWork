package org.albertorado.apigeowork.dtos;

import java.sql.Timestamp;
import java.util.List;

public class ExperienciaDto {

    private int idExperiencia;

    private NivelEducativoDto nivelEducativo;

    private List<SectorDto> sector;

    private ExperienciaTotalDto experienciaTotal;

    private DocumentoDto cvUrl;

    private Timestamp fechaRegistro;

    public int getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public NivelEducativoDto getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(NivelEducativoDto nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public List<SectorDto> getSector() {
        return sector;
    }

    public void setSector(List<SectorDto> sector) {
        this.sector = sector;
    }

    public ExperienciaTotalDto getExperienciaTotal() {
        return experienciaTotal;
    }

    public void setExperienciaTotal(ExperienciaTotalDto experienciaTotal) {
        this.experienciaTotal = experienciaTotal;
    }

    public DocumentoDto getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(DocumentoDto cvUrl) {
        this.cvUrl = cvUrl;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
