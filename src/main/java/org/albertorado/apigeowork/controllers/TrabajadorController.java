package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.TrabajadorDto;
import org.albertorado.apigeowork.entities.Trabajador;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.TrabajadorService;

@RestController
@RequestMapping("/usuario")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;
    private final AutenticacionService autenticacionService;

    public TrabajadorController(TrabajadorService trabajadorService, AutenticacionService autenticacionService) {
        this.trabajadorService = trabajadorService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @PostMapping("/creartrabajador")
    public ResponseEntity<TrabajadorDto> crearTrabajador(@RequestBody Trabajador trabajador){


        TrabajadorDto resultado = trabajadorService.crearTrabajador(trabajador);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscartrabajador/{id}")
    public ResponseEntity<TrabajadorDto> buscarTrabajadorPorId(@RequestHeader("authorization") String autorizacion,
                                                               @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        TrabajadorDto resultado = trabajadorService.buscarTrabajadorPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizartrabajador/{id}")
    public ResponseEntity<TrabajadorDto> actualizarTrabajador(@RequestHeader("authorization") String autorizacion,
                                                              @PathVariable int id,
                                                              @RequestBody Trabajador trabajador){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        TrabajadorDto resultado = trabajadorService.actualizarTrabajador(id,trabajador);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrartrabajador/{id}")
    public ResponseEntity<Void> borrarTrabajador(@RequestHeader("authorization") String autorizacion,
                                                 @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        trabajadorService.borrarTrabajador(id);
        return ResponseEntity.noContent().build();
    }
}
