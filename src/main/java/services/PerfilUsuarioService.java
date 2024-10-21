package services;

import dtos.PerfilUsuarioDto;
import entities.PerfilUsuario;
import mapper.PerfilUsuarioMapper;
import org.springframework.stereotype.Service;
import repositories.PerfilUsuarioRepository;

import java.util.Optional;

@Service
public class PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilUsuarioRepository;
    private final PerfilUsuarioMapper perfilUsuarioMapper;

    public PerfilUsuarioService(PerfilUsuarioRepository perfilUsuarioRepository,PerfilUsuarioMapper perfilUsuarioMapper) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
        this.perfilUsuarioMapper = perfilUsuarioMapper;
    }

    public PerfilUsuarioDto obtenerPerfilPorId(int id) {
        Optional<PerfilUsuarioDto> resultado = perfilUsuarioRepository.findByIdUsuario(id);

        return resultado.orElseGet(null);
    }

    public PerfilUsuarioDto crearPerfil(PerfilUsuario perfilUsuario) {
        PerfilUsuario creado = perfilUsuarioRepository.save(perfilUsuario);
        return perfilUsuarioMapper.toDto(creado);
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
