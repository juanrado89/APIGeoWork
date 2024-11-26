package org.albertorado.apigeowork.dtos;


public class PerfilEmpresaPDto {

    private int idUsuario;

    private String password;

    private EmpresaDto empresa;

    private FotoDto foto;

    private String email;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmpresaDto getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDto empresa) {
        this.empresa = empresa;
    }

    public FotoDto getFoto() {
        return foto;
    }

    public void setFoto(FotoDto foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
