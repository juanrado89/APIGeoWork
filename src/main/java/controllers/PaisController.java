package controllers;

import dtos.PaisDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.PaisService;


@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping("/buscarpaisporid/{id}")
    public ResponseEntity<PaisDto> buscarPorId(@PathVariable int id){
        PaisDto resultado = paisService.getPaisPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarpaispornombre/{nombre}")
    public  ResponseEntity<PaisDto> buscarPorNombre(@PathVariable String nombre){
        PaisDto resultado = paisService.getPaisPorNombre(nombre);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
