package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.NivelDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.NivelService;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nivel")
public class NivelController {

    private final NivelService nivelService;
    private final AutenticacionService autenticacionService;

    public NivelController(NivelService nivelService, AutenticacionService autenticacionService) {
        this.nivelService = nivelService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/niveles")
    public ResponseEntity<List<NivelDto>> buscarNiveles() {
        List<NivelDto> resultado = nivelService.buscarTodos();
        if(resultado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.ok(resultado);
        }

    }

    @GetMapping("/buscarporid/{id}")
    public ResponseEntity<NivelDto> buscarPorId(@RequestHeader("authorization") String autorizacion, @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        NivelDto resultado = nivelService.buscarPorId(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/buscarpornombre/{nombre}")
    public ResponseEntity<NivelDto> buscarPorId(@RequestHeader("authorization") String autorizacion,
                                                @PathVariable String nombre) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        NivelDto resultado = nivelService.buscarPorNombre(nombre);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }

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
