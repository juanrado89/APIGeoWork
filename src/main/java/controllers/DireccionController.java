package controllers;

import dtos.DireccionDto;
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

    @GetMapping("/direccionporid/{id}")
    public ResponseEntity<DireccionDto> getDireccionPorId(@PathVariable int id){
        DireccionDto resultado = direccionService.direccionPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrardireccionporid/{id}")
    public void borrarDireccionPorId(@PathVariable int id){

    }
}
