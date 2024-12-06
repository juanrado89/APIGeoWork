package org.albertorado.apigeowork.controllers;

import jakarta.transaction.Transactional;
import org.albertorado.apigeowork.dtos.DescripcionExperienciaDto;
import org.albertorado.apigeowork.entities.DescripcionExperiencia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.DescripcionExperienciaSerice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<DescripcionExperienciaDto> crearDescripcionExperiencia(@RequestBody DescripcionExperiencia descripcionExperiencia){


        DescripcionExperienciaDto resultado = descripcionExperienciaSerice.crearDescripcionExperiencia(descripcionExperiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creardescripcionesexperiencia")
    public ResponseEntity<List<DescripcionExperienciaDto>> crearDescripcionExperiencia(@RequestBody List<DescripcionExperiencia> descripcionExperiencia){


        List<DescripcionExperienciaDto> resultado = descripcionExperienciaSerice.crearDescripcionesExperiencia(descripcionExperiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @PostMapping("actualizardescripcionexperiencia/{id}")
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
