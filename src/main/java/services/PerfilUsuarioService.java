package services;

import dtos.PerfilUsuarioDto;
import entities.PerfilUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PerfilUsuarioRepository;

import java.util.Optional;

@Service
public class PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilUsuarioRepository;

    public PerfilUsuarioService(PerfilUsuarioRepository perfilUsuarioRepository) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
    }

    public PerfilUsuarioDto obtenerPerfilPorId(int id) {
        Optional<PerfilUsuarioDto> resultado = perfilUsuarioRepository.findByIdUsuario(id);

        return resultado.orElseGet(null);
    }

    public PerfilUsuarioDto crearPerfil(PerfilUsuario perfilUsuario) {
        Optional<PerfilUsuarioDto> perfilACrear = perfilUsuarioRepository.findPerfilUsuarioByEmailContainsIgnoreCase(perfilUsuario.getEmail());
        if(perfilACrear.isPresent()) {
            return perfilACrear.get();
        }else{
            perfilUsuarioRepository.save(perfilUsuario);
            Optional<PerfilUsuarioDto> resultado = perfilUsuarioRepository.findPerfilUsuarioByEmailContainsIgnoreCase(perfilUsuario.getEmail());
            return resultado.orElseGet(null);
        }
    }

    public PerfilUsuarioDto actualizarPerfil(int id, PerfilUsuario perfilUsuario) {
        Optional<PerfilUsuarioDto> busqueda = perfilUsuarioRepository.findByIdUsuario(id);
        if(busqueda.isPresent()){
            perfilUsuarioRepository.save(perfilUsuario);
            Optional<PerfilUsuarioDto> resultado = perfilUsuarioRepository.findByIdUsuario(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }
    }

    public void eliminarPerfil(int id) {
        perfilUsuarioRepository.deleteByIdUsuario(id);
    }
}
