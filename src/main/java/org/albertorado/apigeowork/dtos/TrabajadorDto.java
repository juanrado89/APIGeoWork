package org.albertorado.apigeowork.dtos;

public class TrabajadorDto {

    private int idTrabajador;

    private DatosDto datosUsuario;

    private ExperienciaDto datosExperiencia;

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public DatosDto getDatosUsuario() {
        return datosUsuario;
    }

    public void setDatosUsuario(DatosDto datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    public ExperienciaDto getDatosExperiencia() {
        return datosExperiencia;
    }

    public void setDatosExperiencia(ExperienciaDto datosExperiencia) {
        this.datosExperiencia = datosExperiencia;
    }
}
