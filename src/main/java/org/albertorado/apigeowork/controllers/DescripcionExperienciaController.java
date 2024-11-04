package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.DescripcionExperienciaDto;
import org.albertorado.apigeowork.entities.DescripcionExperiencia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.DescripcionExperienciaSerice;

@RestController
@RequestMapping("/descripcionexperiencia")
public class DescripcionExperienciaController {

    private final DescripcionExperienciaSerice descripcionExperienciaSerice;
    private final AutenticacionService autenticacionService;

    public DescripcionExperienciaController(DescripcionExperienciaSerice descripcionExperienciaSerice, AutenticacionService autenticacionService) {
        this.descripcionExperienciaSerice = descripcionExperienciaSerice;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscardescripcionexperienciaporid/{id}")
    public ResponseEntity<DescripcionExperienciaDto> buscarDescripcionExperienciaPorId(
            @RequestHeader("Authorization") String autorizacion, @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        DescripcionExperienciaDto resultado = descripcionExperienciaSerice.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creardescripcionexperiencia")
    public ResponseEntity<DescripcionExperienciaDto> crearDescripcionExperiencia(
            @RequestHeader("Authorization") String autorizacion, @RequestBody DescripcionExperiencia descripcionExperiencia){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        DescripcionExperienciaDto resultado = descripcionExperienciaSerice.crearDescripcionExperiencia(descripcionExperiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizardescripcionexperiencia/{id}")
    public ResponseEntity<DescripcionExperienciaDto> actualizarDescripcionExperiencia(
            @RequestHeader("Authorization") String autorizacion, @PathVariable int id,
            @RequestBody DescripcionExperiencia descripcionExperiencia){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        DescripcionExperienciaDto resultado = descripcionExperienciaSerice.actualizarDescripcionExperiencia(id,descripcionExperiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrardescripcionexperiencia/{id}")
    public ResponseEntity<Void> borrarDescripcionExperiencia(@RequestHeader("Authorization") String autorizacion,
                                                             @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        descripcionExperienciaSerice.borrarDescripcionExperiencia(id);
        return ResponseEntity.noContent().build();
    }
}
