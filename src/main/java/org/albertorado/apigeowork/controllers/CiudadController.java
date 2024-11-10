package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.CiudadDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.CiudadService;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

    private final CiudadService ciudadService;
    private final AutenticacionService autenticacionService;

    public CiudadController(CiudadService ciudadService, AutenticacionService autenticacionService) {
        this.ciudadService = ciudadService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/ciudades")
    public ResponseEntity<List<CiudadDto>> buscarCiudades() {
        List<CiudadDto> resultado = ciudadService.buscarTodos();
        if(resultado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.ok(resultado);
        }

    }

    @GetMapping("/buscarciudadporid/{id}")
    public ResponseEntity<CiudadDto> buscarCiudadPorId(@RequestHeader("authorization") String autorizacion,
                                                       @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        CiudadDto resultado = ciudadService.buscarCiudadPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarciudadpornombre/{nombre}")
    public ResponseEntity<CiudadDto> buscarCiudadPorId(@RequestHeader("authorization") String autorizacion,
                                                       @PathVariable String nombre){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        CiudadDto resultado = ciudadService.buscarCiudadPorNombre(nombre);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
