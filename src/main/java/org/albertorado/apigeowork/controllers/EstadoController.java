package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.EstadoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.EstadoService;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoService estadoService;
    private final AutenticacionService autenticacionService;

    public EstadoController(EstadoService estadoService, AutenticacionService autenticacionService) {
        this.estadoService = estadoService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/estados")
    public ResponseEntity<List<EstadoDto>> buscarEstados() {
        List<EstadoDto> resultado = estadoService.buscarTodos();
        if(resultado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        }
    }

    @GetMapping("/buscarestadoporid/{id}")
    public ResponseEntity<EstadoDto> buscarEstadoPorId(@RequestHeader("authorization") String autorizacion,
                                                       @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        EstadoDto resultado = estadoService.buscarEstadoPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarestadopornombre/{nombre}")
    public ResponseEntity<EstadoDto> buscarEstadoPorNombre(@RequestHeader("authorization") String autorizacion,
                                                           @PathVariable String nombre){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        EstadoDto resultado = estadoService.buscarEstadoPorNombre(nombre);
        if(resultado != null){
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
