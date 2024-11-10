package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.PaisDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.PaisService;

import java.util.List;


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

    @GetMapping("/paises")
    public ResponseEntity<List<PaisDto>> bucarPaises() {
        List<PaisDto> resultado = paisService.buscarTodos();
        if (resultado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.ok(resultado);
        }
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
