package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.entities.Autenticacion;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;

import java.util.Map;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    private final AutenticacionService autenticacionService;

    public AutenticacionController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;

    }

    @PostMapping("/login/usuario")
    public ResponseEntity<?> autenticarUsuario(@RequestBody PerfilUsuario perfilUsuario) {
        try {
            Autenticacion autenticacion = autenticacionService.autenticacionUsuario(perfilUsuario.getEmail(),perfilUsuario.getPassword(),true);
            return ResponseEntity.ok(autenticacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales de usuario inválidas: " + e.getMessage());
        }
    }

    @PostMapping("/login/empresa")
    public ResponseEntity<?> autenticarEmpresa(@RequestBody PerfilEmpresa perfilEmpresa) {
        try {
            Autenticacion autenticacion = autenticacionService.autenticacionUsuario(perfilEmpresa.getEmail(),perfilEmpresa.getPassword(), false);
            return ResponseEntity.ok(autenticacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales de empresa inválidas: " + e.getMessage());
        }
    }

    @PostMapping("/login/validartoken")
    public ResponseEntity<Void> validarToken(@RequestBody String token) {
        if(autenticacionService.validarToken(token)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}


