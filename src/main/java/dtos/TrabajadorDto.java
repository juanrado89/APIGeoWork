package dtos;

import entities.Datos;
import entities.Experiencia;
import entities.HorarioEntrevista;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

public interface TrabajadorDto {
    int getIdTrabajador();

    DatosDto GetDatosUsuario();

    ExperienciaDto GetDatosExperiencia();

    List<HorarioEntrevistaDto> getHorarios();
}
