package services;

import dtos.PerfilEmpresaDto;
import dtos.PerfilUsuarioDto;
import entities.PerfilEmpresa;
import mapper.PerfilEmpresaMapper;
import org.springframework.stereotype.Service;
import repositories.PerfilEmpresaRepository;

import java.util.Optional;

@Service
public class PerfilEmpresaService {

    private final PerfilEmpresaRepository perfilEmpresaRepository;
    private final PerfilEmpresaMapper perfilEmpresaMapper;

    public PerfilEmpresaService(PerfilEmpresaRepository perfilEmpresaRepository, PerfilEmpresaMapper perfilEmpresaMapper) {
        this.perfilEmpresaRepository = perfilEmpresaRepository;
        this.perfilEmpresaMapper = perfilEmpresaMapper;
    }

    public PerfilEmpresaDto obtenerPerfilPorId(int id) {
        Optional<PerfilEmpresaDto> perfil = perfilEmpresaRepository.findByIdUsuario(id);
        return perfil.orElseGet(null);
    }

    public PerfilEmpresaDto crearPerfil(PerfilEmpresa perfilEmpresa) {
        PerfilEmpresa creado = perfilEmpresaRepository.save(perfilEmpresa);
        return perfilEmpresaMapper.toDto(creado);
    }

    public PerfilEmpresaDto actualizarPerfil(int id, PerfilEmpresa perfilEmpresa) {
        Optional<PerfilEmpresaDto> busqueda = perfilEmpresaRepository.findByIdUsuario(id);
        if(busqueda.isPresent()){
            perfilEmpresaRepository.save(perfilEmpresa);
            Optional<PerfilEmpresaDto> resultado = perfilEmpresaRepository.findByIdUsuario(id);
            return resultado.orElseGet(null);
        }else{
            return null;
        }
    }

    public void eliminarPerfil(int id) {
        perfilEmpresaRepository.deletePerfilEmpresaByIdEmpresa(id);
    }
}
