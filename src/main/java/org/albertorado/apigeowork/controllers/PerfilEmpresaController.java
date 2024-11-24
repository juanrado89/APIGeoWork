package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.PerfilEmpresaDto;
import org.albertorado.apigeowork.dtos.PerfilEmpresaPDto;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.PerfilEmpresaService;

@RestController
@RequestMapping("/perfilempresa")
public class PerfilEmpresaController {

    private final PerfilEmpresaService perfilEmpresaService;
    private final AutenticacionService autenticacionService;

    public PerfilEmpresaController(PerfilEmpresaService perfilEmpresaService, AutenticacionService autenticacionService) {
        this.perfilEmpresaService = perfilEmpresaService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscarperfile/{id}")
    public ResponseEntity<PerfilEmpresaDto> buscarPerfilEPorId(@RequestHeader("authorization") String autorizacion,
                                                               @PathVariable int id) {
        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        PerfilEmpresaDto perfil = perfilEmpresaService.buscarPerfilEPorId(id);
        if(perfil != null) {
            return ResponseEntity.ok(perfil);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/bc")
    public ResponseEntity<PerfilEmpresaPDto> buscarPerfilPorCorreo(@RequestBody String correo) {
        PerfilEmpresaPDto perfilEncontrado = perfilEmpresaService.buscarPorCorreo(correo);
        if(perfilEncontrado != null) {
            return ResponseEntity.ok(perfilEncontrado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("crearperfile")
    public ResponseEntity<PerfilEmpresaDto> crearPerfilE(@RequestBody PerfilEmpresa perfilEmpresa) {


        PerfilEmpresaDto nuevoPerfil = perfilEmpresaService.crearPerfilE(perfilEmpresa);
        if(nuevoPerfil != null) {
            return ResponseEntity.ok(nuevoPerfil);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/actualizarperfile/{id}")
    public ResponseEntity<PerfilEmpresaDto> actualizarPerfilE(@RequestHeader("authorization") String autorizacion,
                                                              @PathVariable int id,
                                                              @RequestBody PerfilEmpresa perfilEmpresa) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        PerfilEmpresaDto perfilActualizado = perfilEmpresaService.actualizarPerfilE(id, perfilEmpresa);
        if(perfilActualizado != null) {
            return ResponseEntity.ok(perfilActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/cc/{id}")
    public ResponseEntity<Void> actualizarContrasena(@PathVariable int id,
                                                              @RequestBody String contrasena) {
        perfilEmpresaService.actualizarContrasena(id, contrasena);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("borrarperfile/{id}")
    public ResponseEntity<Void> eliminarPerfilE(@RequestHeader("authorization") String autorizacion, @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        perfilEmpresaService.eliminarPerfilE(id);
        return ResponseEntity.noContent().build();
    }
}
