package org.albertorado.apigeowork.services;


import org.albertorado.apigeowork.dtos.DatosEmpresaDto;
import org.albertorado.apigeowork.entities.DatosEmpresa;
import org.albertorado.apigeowork.mapper.DatosEmpresaMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.DatosEmpresaRepository;
import java.util.Optional;
@Service
public class DatosEmpresaService {

    private final DatosEmpresaRepository datosEmpresaRepository;
    private final DatosEmpresaMapper datosEmpresaMapper;

    public DatosEmpresaService(DatosEmpresaRepository datosEmpresaRepository, DatosEmpresaMapper datosEmpresaMapper) {
        this.datosEmpresaRepository = datosEmpresaRepository;
        this.datosEmpresaMapper = datosEmpresaMapper;
    }

    public DatosEmpresaDto buscarPorId(int id) {
        Optional<DatosEmpresaDto> resultado = datosEmpresaRepository.findDatosEmpresaByIdDatosEmpresa(id);
        return resultado.orElseGet(null);
    }

    public DatosEmpresaDto crearDatosEmpresa(DatosEmpresa datosEmpresa) {

        DatosEmpresa creada = datosEmpresaRepository.save(datosEmpresa);
        return datosEmpresaMapper.toDto(creada);

    }

    public DatosEmpresaDto actualizarDatosEmpresa(int id, DatosEmpresa datosEmpresa) {

        Optional<DatosEmpresaDto> busqueda = datosEmpresaRepository.findDatosEmpresaByIdDatosEmpresa(id);
        if(busqueda.isPresent()){
            datosEmpresaRepository.save(datosEmpresa);
            Optional<DatosEmpresaDto> resultado = datosEmpresaRepository.findDatosEmpresaByIdDatosEmpresa(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }

    }

    public void borrarDatosEmpresa(int id) {

        datosEmpresaRepository.deleteByIdDatosEmpresa(id);

    }
}
