package org.albertorado.apigeowork.dtos;

import org.albertorado.apigeowork.entities.HorarioEntrevista;

import java.util.List;

public class PerfilUsuarioPDto {

    private int idPerfil;

    private String password;

    private TrabajadorDto trabajador;

    private String email;

    private FotoDto foto;
    private List<OfertaEmpleoDto> ofertas;
    private List<HorarioEntrevista> horarios;

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TrabajadorDto getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TrabajadorDto trabajador) {
        this.trabajador = trabajador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FotoDto getFoto() {
        return foto;
    }

    public void setFoto(FotoDto foto) {
        this.foto = foto;
    }

    public List<OfertaEmpleoDto> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<OfertaEmpleoDto> ofertas) {
        this.ofertas = ofertas;
    }
    public List<HorarioEntrevista> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioEntrevista> horarios) {
        this.horarios = horarios;
    }
}
