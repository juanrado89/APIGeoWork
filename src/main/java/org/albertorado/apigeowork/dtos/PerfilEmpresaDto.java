package org.albertorado.apigeowork.dtos;

import java.util.List;

public class PerfilEmpresaDto {

    private int idUsuario;
    private EmpresaDto empresa;
    private List<SectorDto> sector;
    private String email;
    private FotoDto foto;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public EmpresaDto getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDto empresa) {
        this.empresa = empresa;
    }

    public List<SectorDto> getSector() {
        return sector;
    }

    public void setSector(List<SectorDto> sector) {
        this.sector = sector;
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
}
