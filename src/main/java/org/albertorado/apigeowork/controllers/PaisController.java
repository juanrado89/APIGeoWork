package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.PaisDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.PaisService;


@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisService paisService;
    private final AutenticacionService autenticacionService;

    public PaisController(PaisService paisService, AutenticacionService autenticacionService) {
        this.paisService = paisService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscarpaisporid/{id}")
    public ResponseEntity<PaisDto> buscarPorId(@RequestHeader("authorization") String autorizacion, @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        PaisDto resultado = paisService.getPaisPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarpaispornombre/{nombre}")
    public  ResponseEntity<PaisDto> buscarPorNombre(@RequestHeader("authorization") String autorizacion,
                                                    @PathVariable String nombre){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        PaisDto resultado = paisService.getPaisPorNombre(nombre);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
