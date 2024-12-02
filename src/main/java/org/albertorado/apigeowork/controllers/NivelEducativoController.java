package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.NivelEducativoDto;
import org.albertorado.apigeowork.entities.NivelEducativo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.NivelEducativoService;

import java.util.List;

@RestController
@RequestMapping("/niveleducativo")
public class NivelEducativoController {

    private final NivelEducativoService nivelEducativoService;
    private final AutenticacionService autenticacionService;

    public NivelEducativoController(NivelEducativoService nivelEducativoService, AutenticacionService autenticacionService) {
        this.nivelEducativoService = nivelEducativoService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscarporidniveleducativo/{id}")
    public ResponseEntity<NivelEducativoDto> buscarPorId(@RequestHeader("authorization") String autorizacion,
                                                         @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        NivelEducativoDto resultado = nivelEducativoService.buscarPorId(id);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarportitulo")
    public ResponseEntity<List<NivelEducativoDto>> buscarPortitulo(@RequestHeader("authorization") String autorizacion,
                                                                   @RequestBody String titulo) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<NivelEducativoDto> resultado = nivelEducativoService.buscarPortitulo(titulo);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearniveleducativo")
    public ResponseEntity<NivelEducativoDto> crearNivelEducativo(@RequestBody NivelEducativo nivelEducativo) {


        NivelEducativoDto resultado = nivelEducativoService.crearNivelEducativo(nivelEducativo);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizarniveleducativo/{id}")
    public ResponseEntity<NivelEducativoDto> actualizarHorario(@RequestHeader("authorization") String autorizacion,
                                                               @PathVariable int id,
                                                               @RequestBody NivelEducativo nivelEducativo) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        NivelEducativoDto resultado = nivelEducativoService.actualizarNivelEducativo(id, nivelEducativo);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/borrarniveleducativo/{id}")
    public ResponseEntity<Void> borrarNivelEducativo(@RequestHeader("authorization") String autorizacion, @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        nivelEducativoService.borrarNivelEducativo(id);
        return ResponseEntity.noContent().build();
    }
}
