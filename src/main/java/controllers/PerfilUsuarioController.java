package controllers;

import dtos.PerfilUsuarioDto;
import entities.PerfilUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.PerfilUsuarioService;


@RestController
@RequestMapping("/perfilusuarios")
public class PerfilUsuarioController {

    private final PerfilUsuarioService perfilUsuarioService;

    public PerfilUsuarioController(PerfilUsuarioService perfilUsuarioService) {
        this.perfilUsuarioService = perfilUsuarioService;
    }


    @GetMapping("/buscarperfilu/{id}")
    public ResponseEntity<PerfilUsuarioDto> obtenerPerfilPorId(@PathVariable int id) {
        PerfilUsuarioDto perfil = perfilUsuarioService.obtenerPerfilPorId(id);
        if(perfil != null) {
            return ResponseEntity.ok(perfil);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("crearperfilu")
    public ResponseEntity<PerfilUsuarioDto> crearPerfil(@RequestBody PerfilUsuario perfilUsuario) {
        PerfilUsuarioDto nuevoPerfil = perfilUsuarioService.crearPerfil(perfilUsuario);
        if(nuevoPerfil != null) {
            return ResponseEntity.ok(nuevoPerfil);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/actualizarperfilu/{id}")
    public ResponseEntity<PerfilUsuarioDto> actualizarPerfil(@PathVariable int id, @RequestBody PerfilUsuario perfilUsuario) {
        PerfilUsuarioDto perfilActualizado = perfilUsuarioService.actualizarPerfil(id, perfilUsuario);
        if(perfilActualizado != null) {
            return ResponseEntity.ok(perfilActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("borrarperfilu/{id}")
    public ResponseEntity<Void> eliminarPerfil(@PathVariable int id) {
        perfilUsuarioService.eliminarPerfil(id);
        return ResponseEntity.noContent().build();
    }
}

