package org.albertorado.apigeowork.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.albertorado.apigeowork.dtos.HorarioEntrevistaDto;
import org.albertorado.apigeowork.dtos.TrabajadorDto;
import org.albertorado.apigeowork.entities.HorarioEntrevista;
import org.albertorado.apigeowork.entities.Trabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-02T11:26:39+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class HorarioEntrevistaMapperImpl implements HorarioEntrevistaMapper {

    @Autowired
    private TrabajadorMapper trabajadorMapper;

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
        horarioEntrevistaDto.setTrabajadores( trabajadorListToTrabajadorDtoList( horarioEntrevista.getTrabajadores() ) );

        return horarioEntrevistaDto;
    }

    @Override
    public HorarioEntrevista toEntity(HorarioEntrevistaDto horarioEntrevistaDto) {
        if ( horarioEntrevistaDto == null ) {
            return null;
        }

        HorarioEntrevista horarioEntrevista = new HorarioEntrevista();

        horarioEntrevista.setIdHorario( horarioEntrevistaDto.getIdHorario() );
        horarioEntrevista.setDia( horarioEntrevistaDto.getDia() );
        horarioEntrevista.setHora( horarioEntrevistaDto.getHora() );
        horarioEntrevista.setCandidatosDisponibles( horarioEntrevistaDto.getCandidatosDisponibles() );
        horarioEntrevista.setCandidatosAsignados( horarioEntrevistaDto.getCandidatosAsignados() );
        horarioEntrevista.setTrabajadores( trabajadorDtoListToTrabajadorList( horarioEntrevistaDto.getTrabajadores() ) );

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

    protected List<TrabajadorDto> trabajadorListToTrabajadorDtoList(List<Trabajador> list) {
        if ( list == null ) {
            return null;
        }

        List<TrabajadorDto> list1 = new ArrayList<TrabajadorDto>( list.size() );
        for ( Trabajador trabajador : list ) {
            list1.add( trabajadorMapper.toDto( trabajador ) );
        }

        return list1;
    }

    protected List<Trabajador> trabajadorDtoListToTrabajadorList(List<TrabajadorDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Trabajador> list1 = new ArrayList<Trabajador>( list.size() );
        for ( TrabajadorDto trabajadorDto : list ) {
            list1.add( trabajadorMapper.toEntity( trabajadorDto ) );
        }

        return list1;
    }
}
