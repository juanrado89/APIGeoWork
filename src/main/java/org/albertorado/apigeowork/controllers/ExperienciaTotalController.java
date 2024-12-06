package org.albertorado.apigeowork.controllers;

import jakarta.transaction.Transactional;
import org.albertorado.apigeowork.dtos.ExperienciaTotalDto;
import org.albertorado.apigeowork.entities.ExperienciaTotal;
import org.springframework.http.HttpStatus;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.ExperienciaTotalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;


@RestController
@RequestMapping("experienciatotal")
public class ExperienciaTotalController {

    private final ExperienciaTotalService experienciaTotalService;
    private final AutenticacionService autenticacionService;

    public ExperienciaTotalController(ExperienciaTotalService experienciaTotalService, AutenticacionService autenticacionService) {
        this.experienciaTotalService = experienciaTotalService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscaresperienciatotalporid/{id}")
    public ResponseEntity<ExperienciaTotalDto> buscarPorId(@RequestHeader("authorization") String autorizacion,
                                                           @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        ExperienciaTotalDto resultado = experienciaTotalService.buscarPorId(id);
        if(resultado != null) {
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearexperienciatotal")
    public ResponseEntity<ExperienciaTotalDto> crearExperienciaTotal(@RequestBody ExperienciaTotal experienciaTotal) {


        ExperienciaTotalDto resultado = experienciaTotalService.crearExperiencia(experienciaTotal);
        if(resultado != null) {
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @Transactional
    @PostMapping("/actualizarexperiencia/{id}")
    public ResponseEntity<ExperienciaTotalDto> actualizarExperiencia(@RequestHeader("authorization") String autorizacion,
                                                                     @PathVariable int id,
                                                                     @RequestBody ExperienciaTotal experiencia){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        ExperienciaTotalDto resultado = experienciaTotalService.actualizarExperiencia(id,experiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarexperienciatotal/{id}")
    public ResponseEntity<Void> borrarExperiencia(@RequestHeader("authorization") String autorizacion, @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        experienciaTotalService.borrarExperiencia(id);
        return ResponseEntity.noContent().build();
    }
    @ControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(Exception.class)
        public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", ex.getMessage()));
        }
    }

}
