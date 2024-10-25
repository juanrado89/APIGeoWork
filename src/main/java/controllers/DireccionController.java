package controllers;

import dtos.DireccionDto;
import entities.Direccion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.DireccionService;

@RestController
@RequestMapping("/direccion")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping("/creardireccion")
    public ResponseEntity<DireccionDto> crearDireccion(@RequestParam Direccion direccion){
        DireccionDto resultado = direccionService.crearDireccion(direccion);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/buscardireccionporid/{id}")
    public ResponseEntity<DireccionDto> buscarDireccionPorId(@PathVariable int id){
        DireccionDto resultado = direccionService.direccionPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizardireccion/{id}")
    public ResponseEntity<DireccionDto> actualizarDireccion(@PathVariable int id, @RequestParam Direccion direccion){
        DireccionDto resultado = direccionService.actualizarDireccion(id,direccion);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrardireccionporid/{id}")
    public ResponseEntity<Void> borrarDireccionPorId(@PathVariable int id){
        direccionService.borrarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
