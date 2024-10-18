package controllers;

import dtos.TrabajadorDto;
import entities.Trabajador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.TrabajadorService;

@RestController
@RequestMapping("/usuario")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @PostMapping("/creartrabajador")
    public ResponseEntity<TrabajadorDto> crearTrabajador(@RequestParam Trabajador trabajador){
        TrabajadorDto resultado = trabajadorService.crearTrabajador(trabajador);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscartrabajador/{id}")
    public ResponseEntity<TrabajadorDto> buscarTrabajadorPorId(@PathVariable int id){
        TrabajadorDto resultado = trabajadorService.buscarTrabajadorPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizartrabajador/{id}")
    public ResponseEntity<TrabajadorDto> actualizarTrabajador(@PathVariable int id,@RequestParam Trabajador trabajador){
        TrabajadorDto resultado = trabajadorService.actualizarTrabajador(id,trabajador);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrartrabajador/{id}")
    public ResponseEntity<Void> borrarTrabajador(@PathVariable int id){
        trabajadorService.borrarTrabajador(id);
        return ResponseEntity.noContent().build();
    }
}
