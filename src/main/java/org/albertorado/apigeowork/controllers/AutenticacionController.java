package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.entities.Autenticacion;
import org.albertorado.apigeowork.entities.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;


@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    private final AutenticacionService autenticacionService;

    public AutenticacionController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;

    }

    @PostMapping("/login/usuario")
    public ResponseEntity<Autenticacion> autenticarUsuario(@RequestBody Login login) {
        try {
            System.out.println(login.getMail());
            System.out.println(login.getPassword());
            Autenticacion autenticacion = autenticacionService.autenticacionUsuario(login.getMail(), login.getPassword(), true);
            return ResponseEntity.ok(autenticacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/login/empresa")
    public ResponseEntity<Autenticacion> autenticarEmpresa(@RequestBody Login login) {
        try {
            System.out.println(login.getMail());
            System.out.println(login.getPassword());
            Autenticacion autenticacion = autenticacionService.autenticacionUsuario(login.getMail(), login.getPassword(), false);
            return ResponseEntity.ok(autenticacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/login/validartoken")
    public ResponseEntity<Void> validarToken(@RequestHeader("Authorization") String autorizacion) {
        if(autenticacionService.validarToken(autorizacion)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/login/revocartoken")
    public ResponseEntity<Void> revocarToken(@RequestHeader("Authorization") String autorizacion) {
        autenticacionService.revocarToken(autorizacion);
        return ResponseEntity.ok().build();
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


