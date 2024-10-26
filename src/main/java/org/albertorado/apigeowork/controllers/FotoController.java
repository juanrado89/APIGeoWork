package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.FotoDto;
import org.albertorado.apigeowork.entities.Foto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.FotoService;


@RestController
@RequestMapping("/foto")
public class FotoController {
    private final FotoService fotoService;
    private final AutenticacionService autenticacionService;

    public FotoController(FotoService fotoService, AutenticacionService autenticacionService) {
        this.fotoService = fotoService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscarfotoporid/{id}")
    public ResponseEntity<FotoDto> buscarFotoPorId(@RequestHeader("authorization") String autorizacion, @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        FotoDto resultado = fotoService.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearfoto")
    public ResponseEntity<FotoDto> crearFoto(@RequestHeader("authorization") String autorizacion, @RequestParam Foto foto){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        FotoDto resultado = fotoService.crearFoto(foto);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizarfoto/{id}")
    public ResponseEntity<FotoDto> actualizarFoto(@RequestHeader("authorization") String autorizacion, @PathVariable int id,@RequestParam Foto foto){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        FotoDto resultado = fotoService.actualizarFoto(id,foto);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarfoto/{id}")
    public ResponseEntity<Void> borrarFoto(@RequestHeader("authorization") String autorizacion, @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        fotoService.borrarFoto(id);
        return ResponseEntity.noContent().build();
    }
}
