package dtos;

import entities.NivelEducativo;

import java.sql.Timestamp;

public interface NivelEducativoDto {

    public int getIdNivelEducativo();
    public String getTituloNivelEducativo();
    public Timestamp getFechaInicio();
    public Timestamp getFechaFin();
    public NivelDto getNivel();
}
