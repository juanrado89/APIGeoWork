package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.PerfilUsuarioDto;
import org.albertorado.apigeowork.dtos.PerfilUsuarioPDto;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.PerfilUsuarioService;

import java.util.List;


@RestController
@RequestMapping("/perfilusuario")
public class PerfilUsuarioController {

    private final PerfilUsuarioService perfilUsuarioService;
    private final AutenticacionService autenticacionService;

    public PerfilUsuarioController(PerfilUsuarioService perfilUsuarioService, AutenticacionService autenticacionService) {
        this.perfilUsuarioService = perfilUsuarioService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }



    @GetMapping("/buscarperfilu/{id}")
    public ResponseEntity<PerfilUsuarioDto> buscarPerfilUPorId(@RequestHeader("authorization") String autorizacion,
                                                               @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        PerfilUsuarioDto perfil = perfilUsuarioService.buscarPerfilUPorId(id);
        if(perfil != null) {
            return ResponseEntity.ok(perfil);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/buscartodosperfilu")
    public ResponseEntity<List<PerfilUsuarioDto>> buscarPerfilUPorId(@RequestHeader("authorization") String autorizacion) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<PerfilUsuarioDto> perfiles = perfilUsuarioService.buscarTodos();
        if(perfiles != null) {
            return ResponseEntity.ok(perfiles);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/bc")
    public ResponseEntity<PerfilUsuarioPDto> buscarPerfilPorCorreo(@RequestBody String correo) {
        PerfilUsuarioPDto perfilEncontrado = perfilUsuarioService.buscarPorCorreo(correo);
        if(perfilEncontrado != null) {
            return ResponseEntity.ok(perfilEncontrado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearperfilu")
    public ResponseEntity<PerfilUsuarioDto> crearPerfilU(@RequestBody PerfilUsuario perfilUsuario) {

        PerfilUsuarioDto nuevoPerfil = perfilUsuarioService.crearPerfilU(perfilUsuario);
        if(nuevoPerfil != null) {
            return ResponseEntity.ok(nuevoPerfil);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/actualizarperfilu/{id}")
    public ResponseEntity<PerfilUsuarioDto> actualizarPerfilU(@RequestHeader("authorization") String autorizacion,
                                                              @PathVariable int id,
                                                              @RequestBody PerfilUsuario perfilUsuario) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        PerfilUsuarioDto perfilActualizado = perfilUsuarioService.actualizarPerfilU(id, perfilUsuario);
        if(perfilActualizado != null) {
            return ResponseEntity.ok(perfilActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/cc/{id}")
    public ResponseEntity<Void> cambiarContrasena(@PathVariable int id,
                                                  @RequestBody String contrasena) {
        perfilUsuarioService.cambiarContrsena(id, contrasena);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/borrarperfilu/{id}")
    public ResponseEntity<Void> eliminarPerfilU(@RequestHeader("authorization") String autorizacion,
                                                @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        perfilUsuarioService.eliminarPerfilU(id);
        return ResponseEntity.noContent().build();
    }
}

