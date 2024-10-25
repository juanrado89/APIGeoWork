package controllers;

import dtos.PerfilEmpresaPDto;
import dtos.PerfilUsuarioPDto;
import entities.Autenticacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AutenticacionService;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    private final AutenticacionService autenticacionService;

    public AutenticacionController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticacion(@RequestParam Object perfilUsuario, @RequestParam boolean tipoPerfil) {
        try {
            Autenticacion autenticacion;
            if (tipoPerfil) {
                PerfilUsuarioPDto usuarioDto = (PerfilUsuarioPDto) perfilUsuario;
                autenticacion = autenticacionService.authenticacionUsuario(usuarioDto.getEmail(), usuarioDto.getPassword(), true);
            } else {
                PerfilEmpresaPDto empresaDto = (PerfilEmpresaPDto) perfilUsuario;
                autenticacion = autenticacionService.authenticacionUsuario(empresaDto.getEmail(), empresaDto.getPassword(), false);
            }

            return ResponseEntity.ok(autenticacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas: " + e.getMessage());
        }
    }
}


