package controllers;

import dtos.EstadoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }
    @GetMapping("/estadoporid/{id}")
    public ResponseEntity<EstadoDto> getEstadoPorId(@PathVariable int id){
        EstadoDto resultado = estadoService.getEstadoPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estadopornombre/{nombre}")
    public ResponseEntity<EstadoDto> getEstadoPorNombre(@PathVariable String nombre){
        EstadoDto resultado = estadoService.getEstadoPorNombre(nombre);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
