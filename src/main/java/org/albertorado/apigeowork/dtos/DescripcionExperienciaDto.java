package org.albertorado.apigeowork.dtos;


public class DescripcionExperienciaDto {

    private int idDescripcionExperiencia;
    private String nombreEmpresa;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private ExperienciaTotalDto experienciaTotal;

    public int getIdDescripcionExperiencia() {
        return idDescripcionExperiencia;
    }

    public void setIdDescripcionExperiencia(int idDescripcionExperiencia) {
        this.idDescripcionExperiencia = idDescripcionExperiencia;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ExperienciaTotalDto getExperienciaTotal() {
        return experienciaTotal;
    }

    public void setExperienciaTotal(ExperienciaTotalDto experienciaTotal) {
        this.experienciaTotal = experienciaTotal;
    }
}
