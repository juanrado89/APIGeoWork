package org.albertorado.apigeowork.services;


import org.albertorado.apigeowork.dtos.DatosEmpresaDto;
import org.albertorado.apigeowork.entities.DatosEmpresa;
import org.albertorado.apigeowork.entities.Sector;
import org.albertorado.apigeowork.mapper.DatosEmpresaMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.DatosEmpresaRepository;

import java.util.ArrayList;
import java.util.List;
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
        Optional<DatosEmpresa> resultado = datosEmpresaRepository.findDatosEmpresaByIdDatosEmpresa(id);
        if(resultado.isEmpty()){
            return null;
        }
        return datosEmpresaMapper.toDto(resultado.get());
    }

    public DatosEmpresaDto crearDatosEmpresa(DatosEmpresa datosEmpresa) {

        DatosEmpresa creada = datosEmpresaRepository.save(datosEmpresa);
        return datosEmpresaMapper.toDto(creada);

    }

    public DatosEmpresaDto actualizarDatosEmpresa(int id, DatosEmpresa datosEmpresa) {

        Optional<DatosEmpresa> busqueda = datosEmpresaRepository.findDatosEmpresaByIdDatosEmpresa(id);
        if(busqueda.isPresent()){
            DatosEmpresa existentes = busqueda.get();
            if(datosEmpresa.getNombreEmpresa() != null){
                existentes.setNombreEmpresa(datosEmpresa.getNombreEmpresa());
            }
            if(datosEmpresa.getContactoEmail() != null){
                existentes.setContactoEmail(datosEmpresa.getContactoEmail());
            }
            if(datosEmpresa.getDireccion() != null){
                existentes.setDireccion(datosEmpresa.getDireccion());
            }
            if(datosEmpresa.getContactoNombre() != null){
                existentes.setContactoNombre(datosEmpresa.getContactoNombre());
            }
            if(datosEmpresa.getContactoTelefono() != null){
                existentes.setContactoTelefono(datosEmpresa.getContactoTelefono());
            }
            if(datosEmpresa.getSitioWeb() != null){
                existentes.setSitioWeb(datosEmpresa.getSitioWeb());
            }
            if(!datosEmpresa.getSector().isEmpty()){
                List<Sector> sectores = new ArrayList<>();
                for(Sector sector : datosEmpresa.getSector()){
                    sectores.add(sector);
                }
                existentes.setSector(sectores);
            }
            DatosEmpresa actualizados = datosEmpresaRepository.save(existentes);
            return datosEmpresaMapper.toDto(actualizados);
        }else{
            return null;
        }

    }

    public void borrarDatosEmpresa(int id) {

        datosEmpresaRepository.deleteByIdDatosEmpresa(id);

    }
}
