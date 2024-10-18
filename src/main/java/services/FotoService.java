package services;

import dtos.FotoDto;
import entities.Foto;
import repositories.FotoRepository;

import java.util.Optional;

public class FotoService {
    private final FotoRepository fotoRepository;

    public FotoService(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    public FotoDto buscarPorId(int id) {
        Optional<FotoDto> resultado = fotoRepository.findByIdFoto(id);
        return resultado.orElseGet(null);
    }

    public FotoDto crearFoto(Foto foto) {

        Optional<FotoDto> busqueda = fotoRepository.findByNombreLikeIgnoreCaseAndDatos(foto.getNombre(), foto.getDatos());
        if(busqueda.isPresent()){
            return null;
        }else{
            fotoRepository.save(foto);
            Optional<FotoDto> resultado = fotoRepository.findByNombreLikeIgnoreCaseAndDatos(foto.getNombre(), foto.getDatos());
            return resultado.orElseGet(null);
        }

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
