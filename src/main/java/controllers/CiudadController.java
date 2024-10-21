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

    @GetMapping("/ciudadporid/{id}")
    public ResponseEntity<CiudadDto> getCiudadPorId(@PathVariable int id){
        CiudadDto resultado = ciudadService.buscarCiudadPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ciudadpornombre/{nombre}")
    public ResponseEntity<CiudadDto> getCiudadPorId(@PathVariable String nombre){
        CiudadDto resultado = ciudadService.buscarCiudadPorNombre(nombre);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
