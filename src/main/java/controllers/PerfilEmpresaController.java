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
    public ResponseEntity<PerfilEmpresaDto> buscarPerfilEPorId(@PathVariable int id) {
        PerfilEmpresaDto perfil = perfilEmpresaService.buscarPerfilEPorId(id);
        if(perfil != null) {
            return ResponseEntity.ok(perfil);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("crearperfile")
    public ResponseEntity<PerfilEmpresaDto> crearPerfilE(@RequestBody PerfilEmpresa perfilEmpresa) {
        PerfilEmpresaDto nuevoPerfil = perfilEmpresaService.crearPerfilE(perfilEmpresa);
        if(nuevoPerfil != null) {
            return ResponseEntity.ok(nuevoPerfil);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/actualizarperfile/{id}")
    public ResponseEntity<PerfilEmpresaDto> actualizarPerfilE(@PathVariable int id, @RequestBody PerfilEmpresa perfilEmpresa) {
        PerfilEmpresaDto perfilActualizado = perfilEmpresaService.actualizarPerfilE(id, perfilEmpresa);
        if(perfilActualizado != null) {
            return ResponseEntity.ok(perfilActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("borrarperfile/{id}")
    public ResponseEntity<Void> eliminarPerfilE(@PathVariable int id) {
        perfilEmpresaService.eliminarPerfilE(id);
        return ResponseEntity.noContent().build();
    }
}
