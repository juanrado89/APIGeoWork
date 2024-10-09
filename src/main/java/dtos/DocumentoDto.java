package dtos;

public interface DocumentoDto {

    Long getIdDocumento();
    String getNombre();
    String getTipoContenido();
    byte[] getDatos();
}
