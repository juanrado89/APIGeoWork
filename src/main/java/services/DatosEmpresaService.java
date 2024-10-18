package services;


import dtos.DatosEmpresaDto;
import entities.DatosEmpresa;
import org.springframework.stereotype.Service;
import repositories.DatosEmpresaRepository;
import java.util.Optional;
@Service
public class DatosEmpresaService {

    private final DatosEmpresaRepository datosEmpresaRepository;

    public DatosEmpresaService(DatosEmpresaRepository datosEmpresaRepository) {
        this.datosEmpresaRepository = datosEmpresaRepository;
    }

    public DatosEmpresaDto buscarPorId(int id) {
        Optional<DatosEmpresaDto> resultado = datosEmpresaRepository.findDatosEmpresaByIdDatosEmpresa(id);
        return resultado.orElseGet(null);
    }

    public DatosEmpresaDto crearDatosEmpresa(DatosEmpresa datosEmpresa) {

        Optional<DatosEmpresaDto> busqueda = datosEmpresaRepository.findDatosEmpresaByNombreEmpresaContainsIgnoreCaseAndDireccion_IdDireccion(datosEmpresa.getNombreEmpresa(), datosEmpresa.getDireccion().getIdDireccion());
        if(busqueda.isPresent()){
            return null;
        }else{
            datosEmpresaRepository.save(datosEmpresa);
            Optional<DatosEmpresaDto> resultado = datosEmpresaRepository.findDatosEmpresaByNombreEmpresaContainsIgnoreCaseAndDireccion_IdDireccion(datosEmpresa.getNombreEmpresa(), datosEmpresa.getDireccion().getIdDireccion());
            return resultado.orElseGet(null);
        }

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
