package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.HorarioEntrevistaDto;
import org.albertorado.apigeowork.dtos.PerfilUsuarioDto;
import org.albertorado.apigeowork.entities.HorarioEntrevista;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-11T19:14:53+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class HorarioEntrevistaMapperImpl implements HorarioEntrevistaMapper {

    @Autowired
    private PerfilUsuarioMapper perfilUsuarioMapper;

    @Override
    public HorarioEntrevistaDto toDto(HorarioEntrevista horarioEntrevista) {
        if ( horarioEntrevista == null ) {
            return null;
        }

        HorarioEntrevistaDto horarioEntrevistaDto = new HorarioEntrevistaDto();

        horarioEntrevistaDto.setIdHorario( horarioEntrevista.getIdHorario() );
        horarioEntrevistaDto.setDia( horarioEntrevista.getDia() );
        horarioEntrevistaDto.setHora( horarioEntrevista.getHora() );
        horarioEntrevistaDto.setCandidatosDisponibles( horarioEntrevista.getCandidatosDisponibles() );
        horarioEntrevistaDto.setCandidatosAsignados( horarioEntrevista.getCandidatosAsignados() );
        horarioEntrevistaDto.setTrabajadores( perfilUsuarioMapper.toDto( horarioEntrevista.getTrabajadores() ) );

        return horarioEntrevistaDto;
    }

    @Override
    public HorarioEntrevista toEntity(HorarioEntrevistaDto horarioEntrevistaDto) {
        if ( horarioEntrevistaDto == null ) {
            return null;
        }

        HorarioEntrevista horarioEntrevista = new HorarioEntrevista();

        horarioEntrevista.setIdHorario( horarioEntrevistaDto.getIdHorario() );
        horarioEntrevista.setHora( horarioEntrevistaDto.getHora() );
        horarioEntrevista.setDia( horarioEntrevistaDto.getDia() );
        horarioEntrevista.setCandidatosDisponibles( horarioEntrevistaDto.getCandidatosDisponibles() );
        horarioEntrevista.setCandidatosAsignados( horarioEntrevistaDto.getCandidatosAsignados() );
        horarioEntrevista.setTrabajadores( perfilUsuarioDtoListToPerfilUsuarioList( horarioEntrevistaDto.getTrabajadores() ) );

        return horarioEntrevista;
    }

    @Override
    public List<HorarioEntrevistaDto> toDto(List<HorarioEntrevista> horarios) {
        if ( horarios == null ) {
            return null;
        }

        List<HorarioEntrevistaDto> list = new ArrayList<HorarioEntrevistaDto>( horarios.size() );
        for ( HorarioEntrevista horarioEntrevista : horarios ) {
            list.add( toDto( horarioEntrevista ) );
        }

        return list;
    }

    protected List<PerfilUsuario> perfilUsuarioDtoListToPerfilUsuarioList(List<PerfilUsuarioDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PerfilUsuario> list1 = new ArrayList<PerfilUsuario>( list.size() );
        for ( PerfilUsuarioDto perfilUsuarioDto : list ) {
            list1.add( perfilUsuarioMapper.toEntity( perfilUsuarioDto ) );
        }

        return list1;
    }
}
