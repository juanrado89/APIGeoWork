package controllers;

import dtos.PerfilEmpresaDto;
import entities.PerfilEmpresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.PerfilEmpresaService;

@RestController
@RequestMapping("/perfilempresa")
public class PerfilEmpresaController {

    private final PerfilEmpresaService perfilEmpresaService;

    public PerfilEmpresaController(PerfilEmpresaService perfilEmpresaService) {
        this.perfilEmpresaService = perfilEmpresaService;
    }

    @GetMapping("/buscarperfile/{id}")
    public ResponseEntity<PerfilEmpresaDto> obtenerPerfilPorId(@PathVariable int id) {
        PerfilEmpresaDto perfil = perfilEmpresaService.obtenerPerfilPorId(id);
        if(perfil != null) {
            return ResponseEntity.ok(perfil);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("crearperfile")
    public ResponseEntity<PerfilEmpresaDto> crearPerfil(@RequestBody PerfilEmpresa perfilEmpresa) {
        PerfilEmpresaDto nuevoPerfil = perfilEmpresaService.crearPerfil(perfilEmpresa);
        if(nuevoPerfil != null) {
            return ResponseEntity.ok(nuevoPerfil);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/actualizarperfile/{id}")
    public ResponseEntity<PerfilEmpresaDto> actualizarPerfil(@PathVariable int id, @RequestBody PerfilEmpresa perfilEmpresa) {
        PerfilEmpresaDto perfilActualizado = perfilEmpresaService.actualizarPerfil(id, perfilEmpresa);
        if(perfilActualizado != null) {
            return ResponseEntity.ok(perfilActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("borrarperfile/{id}")
    public ResponseEntity<Void> eliminarPerfil(@PathVariable int id) {
        perfilEmpresaService.eliminarPerfil(id);
        return ResponseEntity.noContent().build();
    }
}
