package controllers;

import dtos.DatosDto;
import entities.Datos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.DatosService;

@RestController
@RequestMapping("/datosusuario")
public class DatosController {

    private final DatosService datosService;

    public DatosController(DatosService datosService) {
        this.datosService = datosService;
    }

    @GetMapping("/buscardatosusuarioporid/{id}")
    public ResponseEntity<DatosDto> buscarDatosPorId(@PathVariable int id){
        DatosDto resultado = datosService.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creardatosusuario")
    public ResponseEntity<DatosDto> crearDatos(@RequestParam Datos datos){
        DatosDto resultado = datosService.crearDatos(datos);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizardatosusuario/{id}")
    public ResponseEntity<DatosDto> actualizarDatos(@PathVariable int id, @RequestParam Datos datos){
        DatosDto resultado = datosService.actualizarDatos(id,datos);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrardatosusuario/{id}")
    public ResponseEntity<Void> borrarDatos(@PathVariable int id){
        datosService.borrarDatos(id);
        return ResponseEntity.noContent().build();
    }
}
