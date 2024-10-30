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
        Optional<FotoDto> resultado = fotoRepository.findByIdFoto(id);
        return resultado.orElseGet(null);
    }

    public FotoDto crearFoto(Foto foto) {

        Foto creada = fotoRepository.save(foto);
        return fotoMapper.toDto(creada);

    }

    public FotoDto actualizarFoto(int id,Foto foto) {

        Optional<FotoDto> busqueda = fotoRepository.findByIdFoto(id);
        if(busqueda.isPresent()){
            fotoRepository.save(foto);
            Optional<FotoDto> resultado = fotoRepository.findByIdFoto(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }

    }

    public void borrarFoto(int id) {

        fotoRepository.deleteFotoByIdFoto(id);

    }
}
