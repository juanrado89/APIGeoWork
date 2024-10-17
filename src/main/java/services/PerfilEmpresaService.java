package services;

import dtos.PerfilEmpresaDto;
import dtos.PerfilUsuarioDto;
import entities.PerfilEmpresa;
import org.springframework.stereotype.Service;
import repositories.PerfilEmpresaRepository;

import java.util.Optional;

@Service
public class PerfilEmpresaService {

    private final PerfilEmpresaRepository perfilEmpresaRepository;

    public PerfilEmpresaService(PerfilEmpresaRepository perfilEmpresaRepository) {
        this.perfilEmpresaRepository = perfilEmpresaRepository;
    }

    public PerfilEmpresaDto obtenerPerfilPorId(int id) {
        Optional<PerfilEmpresaDto> perfil = perfilEmpresaRepository.findByIdUsuario(id);
        return perfil.orElseGet(null);
    }

    public PerfilEmpresaDto crearPerfil(PerfilEmpresa perfilEmpresa) {
        Optional<PerfilEmpresaDto> perfil = perfilEmpresaRepository.findPerfilEmpresaByEmailContainingIgnoreCase(perfilEmpresa.getEmail());
        if(perfil.isPresent()){
            return perfil.get();
        }else{
            perfilEmpresaRepository.save(perfilEmpresa);
            Optional<PerfilEmpresaDto> resultado = perfilEmpresaRepository.findPerfilEmpresaByEmailContainingIgnoreCase(perfilEmpresa.getEmail());
            return resultado.orElse(null);
        }
    }

    public PerfilEmpresaDto actualizarPerfil(int id, PerfilEmpresa perfilEmpresa) {
        if(perfilEmpresaRepository.updatePerfilUsuarioByIdPerfilIs(id,perfilEmpresa) == 1){
            Optional<PerfilEmpresaDto> resultado = perfilEmpresaRepository.findByIdUsuario(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }
    }

    public void eliminarPerfil(int id) {
        perfilEmpresaRepository.deleteByIdUsuario(id);
    }
}
