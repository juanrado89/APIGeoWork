package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.DireccionDto;
import org.albertorado.apigeowork.entities.Direccion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.DireccionService;

@RestController
@RequestMapping("/direccion")
public class DireccionController {

    private final DireccionService direccionService;
    private final AutenticacionService autenticacionService;

    public DireccionController(DireccionService direccionService, AutenticacionService autenticacionService) {
        this.direccionService = direccionService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @PostMapping("/creardireccion")
    public ResponseEntity<DireccionDto> crearDireccion(@RequestBody Direccion direccion){

        DireccionDto resultado = direccionService.crearDireccion(direccion);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/buscardireccionporid/{id}")
    public ResponseEntity<DireccionDto> buscarDireccionPorId(@RequestHeader("authorization") String autorizacion,
                                                             @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        DireccionDto resultado = direccionService.direccionPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizardireccion/{id}")
    public ResponseEntity<DireccionDto> actualizarDireccion(@RequestHeader("authorization") String autorizacion,
                                                            @PathVariable int id, @RequestBody Direccion direccion){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        DireccionDto resultado = direccionService.actualizarDireccion(id,direccion);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrardireccionporid/{id}")
    public ResponseEntity<Void> borrarDireccionPorId(@RequestHeader("authorization") String autorizacion,
                                                     @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        direccionService.borrarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
