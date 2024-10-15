package dtos;

import java.sql.Timestamp;
import java.util.List;

public interface OfertaEmpleoDto {

    int getIdOferta();
    EmpresaDto getEmpresa();
    String getTitulo();
    int getCantidad();
    String getDescripcion();
    String getRequisitos();
    String getNivelEducativoRequerido();
    float getSalarioMin();
    float getSalarioMax();
    DireccionDto getDireccion();
    Timestamp fechaPublicaion();
    int getEstado();
    List<HorarioEntrevistaDto> getHorarios();
}
