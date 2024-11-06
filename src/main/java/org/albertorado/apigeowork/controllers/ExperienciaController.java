package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.ExperienciaDto;
import org.albertorado.apigeowork.entities.Experiencia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.ExperienciaService;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

    private final ExperienciaService experienciaService;
    private final AutenticacionService autenticacionService;

    public ExperienciaController(ExperienciaService experienciaService, AutenticacionService autenticacionService) {
        this.experienciaService = experienciaService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @PostMapping("/crearexperiencia")
    public ResponseEntity<ExperienciaDto> crearExperiencia(@RequestBody Experiencia experiencia){


        ExperienciaDto resultado = experienciaService.crearExperiencia(experiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarexperienciaporid/{id}")
    public ResponseEntity<ExperienciaDto> buscarExperienciaPorId(@RequestHeader("authorization") String autorizacion,
                                                                 @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        ExperienciaDto resultado = experienciaService.buscarExperienciaPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarexperienciaporsector/{sector}")
    public ResponseEntity<List<ExperienciaDto>> buscarExperienciaPorSector(
            @RequestHeader("authorization") String autorizacion, @PathVariable String sector){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<ExperienciaDto> resultado = experienciaService.buscarExperienciaPorSector(sector);
        if(!resultado.isEmpty()){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizarexperiencia/{id}")
    public ResponseEntity<ExperienciaDto> actualizarExperiencia(@RequestHeader("authorization") String autorizacion,
                                                                @PathVariable int id,@RequestBody Experiencia experiencia){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        ExperienciaDto resultado = experienciaService.actualizarExperiencia(id,experiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarexperiencia/{id}")
    public ResponseEntity<Void> borrarExperiencia(@RequestHeader("authorization") String autorizacion, @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        experienciaService.borrarExperiencia(id);
        return ResponseEntity.noContent().build();
    }
}
