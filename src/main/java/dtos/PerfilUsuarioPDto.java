package dtos;

public interface PerfilUsuarioPDto {

    int getIdPerfil();

    String getPassword();

    TrabajadorDto getIdTrabajador();

    String getEmail();

    FotoDto getFoto();
}
