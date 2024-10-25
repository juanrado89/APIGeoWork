package controllers;

import dtos.PerfilUsuarioDto;
import entities.PerfilUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.PerfilUsuarioService;


@RestController
@RequestMapping("/perfilusuario")
public class PerfilUsuarioController {

    private final PerfilUsuarioService perfilUsuarioService;

    public PerfilUsuarioController(PerfilUsuarioService perfilUsuarioService) {
        this.perfilUsuarioService = perfilUsuarioService;
    }


    @GetMapping("/buscarperfilu/{id}")
    public ResponseEntity<PerfilUsuarioDto> buscarPerfilUPorId(@PathVariable int id) {
        PerfilUsuarioDto perfil = perfilUsuarioService.buscarPerfilUPorId(id);
        if(perfil != null) {
            return ResponseEntity.ok(perfil);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearperfilu")
    public ResponseEntity<PerfilUsuarioDto> crearPerfilU(@RequestBody PerfilUsuario perfilUsuario) {
        PerfilUsuarioDto nuevoPerfil = perfilUsuarioService.crearPerfilU(perfilUsuario);
        if(nuevoPerfil != null) {
            return ResponseEntity.ok(nuevoPerfil);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/actualizarperfilu/{id}")
    public ResponseEntity<PerfilUsuarioDto> actualizarPerfilU(@PathVariable int id, @RequestBody PerfilUsuario perfilUsuario) {
        PerfilUsuarioDto perfilActualizado = perfilUsuarioService.actualizarPerfilU(id, perfilUsuario);
        if(perfilActualizado != null) {
            return ResponseEntity.ok(perfilActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/borrarperfilu/{id}")
    public ResponseEntity<Void> eliminarPerfilU(@PathVariable int id) {
        perfilUsuarioService.eliminarPerfilU(id);
        return ResponseEntity.noContent().build();
    }
}

