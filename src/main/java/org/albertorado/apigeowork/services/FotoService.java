package org.albertorado.apigeowork.services;

import org.albertorado.apigeowork.dtos.FotoDto;
import org.albertorado.apigeowork.entities.Foto;
import org.albertorado.apigeowork.mapper.FotoMapper;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.FotoRepository;

import java.util.Optional;

@Service
public class FotoService {
    private final FotoRepository fotoRepository;
    private final FotoMapper fotoMapper;

    public FotoService(FotoRepository fotoRepository, FotoMapper fotoMapper) {
        this.fotoRepository = fotoRepository;
        this.fotoMapper = fotoMapper;
    }

    public FotoDto buscarPorId(int id) {
        Optional<Foto> resultado = fotoRepository.findByIdFoto(id);
        if(resultado.isEmpty()){
            return null;
        }
        return fotoMapper.toDto(resultado.get());
    }

    public FotoDto crearFoto(Foto foto) {

        Foto creada = fotoRepository.save(foto);
        return fotoMapper.toDto(creada);

    }

    public FotoDto actualizarFoto(int id, Foto foto) {
        Optional<Foto> busqueda = fotoRepository.findByIdFoto(id);

        if (busqueda.isPresent()) {
            Foto fotoExistente = busqueda.get();
            if (foto.getNombre() != null) {
                fotoExistente.setNombre(foto.getNombre());
            }
            if (foto.getTipoContenido() != null) {
                fotoExistente.setTipoContenido(foto.getTipoContenido());
            }
            if (foto.getDatos() != null) {
                fotoExistente.setDatos(foto.getDatos());
            }
            Foto actualizada = fotoRepository.save(fotoExistente);
            return fotoMapper.toDto(actualizada);
        } else {
            return null;
        }
    }


    public void borrarFoto(int id) {

        fotoRepository.deleteFotoByIdFoto(id);

    }
}
