package controllers;

import dtos.CiudadDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CiudadService;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping("/buscarciudadporid/{id}")
    public ResponseEntity<CiudadDto> buscarCiudadPorId(@PathVariable int id){
        CiudadDto resultado = ciudadService.buscarCiudadPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarciudadpornombre/{nombre}")
    public ResponseEntity<CiudadDto> buscarCiudadPorId(@PathVariable String nombre){
        CiudadDto resultado = ciudadService.buscarCiudadPorNombre(nombre);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
