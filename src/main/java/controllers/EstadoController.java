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

    @GetMapping("/buscarestadoporid/{id}")
    public ResponseEntity<EstadoDto> buscarEstadoPorId(@PathVariable int id){
        EstadoDto resultado = estadoService.buscarEstadoPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarestadopornombre/{nombre}")
    public ResponseEntity<EstadoDto> buscarEstadoPorNombre(@PathVariable String nombre){
        EstadoDto resultado = estadoService.buscarEstadoPorNombre(nombre);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
