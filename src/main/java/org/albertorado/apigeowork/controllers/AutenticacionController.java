package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.LoginDto;
import org.albertorado.apigeowork.entities.Autenticacion;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;


@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    private final AutenticacionService autenticacionService;

    public AutenticacionController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;

    }

    @PostMapping("/login/usuario")
    public ResponseEntity<Autenticacion> autenticarUsuario(@RequestBody LoginDto loginDto) {
        try {
            Autenticacion autenticacion = autenticacionService.autenticacionUsuario(loginDto.getMail(), loginDto.getPassword(), true);
            return ResponseEntity.ok(autenticacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/login/empresa")
    public ResponseEntity<Autenticacion> autenticarEmpresa(@RequestBody LoginDto loginDto) {
        try {
            Autenticacion autenticacion = autenticacionService.autenticacionUsuario(loginDto.getMail(), loginDto.getPassword(), false);
            return ResponseEntity.ok(autenticacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/login/validartoken")
    public ResponseEntity<Void> validarToken(@RequestParam String token) {
        if(autenticacionService.validarToken(token)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/login/revocartoken")
    public ResponseEntity<Void> revocarToken(@RequestParam String token) {
        autenticacionService.revocarToken(token);
        return ResponseEntity.ok().build();
    }
}


