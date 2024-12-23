package org.albertorado.apigeowork.controllers;

import jakarta.transaction.Transactional;
import org.albertorado.apigeowork.dtos.OfertaEmpleoDto;
import org.albertorado.apigeowork.dtos.OfertaEmpleoFiltroDto;
import org.albertorado.apigeowork.entities.OfertaEmpleo;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.OfertaEmpleoService;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ofertadeempleo")
public class OfertaEmpleoController {

    OfertaEmpleoService ofertaEmpleoService;
    private final AutenticacionService autenticacionService;

    public OfertaEmpleoController(OfertaEmpleoService ofertaEmpleoService, AutenticacionService autenticacionService) {
        this.ofertaEmpleoService = ofertaEmpleoService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }
    @GetMapping("/buscarofertas")
    public ResponseEntity<List<OfertaEmpleoDto>> buscarTodas(@RequestHeader("authorization") String autorizacion) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<OfertaEmpleoDto> resultado = ofertaEmpleoService.buscarTodas();
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarofertaporid/{id}")
    public ResponseEntity<OfertaEmpleoDto> buscarPorId(@RequestHeader("authorization") String autorizacion, @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        OfertaEmpleoDto resultado = ofertaEmpleoService.buscarPorId(id);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/buscarporparametros")
    public ResponseEntity<List<OfertaEmpleoDto>> buscarPorParametros(@RequestHeader("authorization") String autorizacion,
                                                                     @RequestBody OfertaEmpleoFiltroDto parametros) {
        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


        List<OfertaEmpleoDto> resultado = ofertaEmpleoService.buscarPorParametros(parametros);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/buscarporidempresa/{id}")
    public ResponseEntity<List<OfertaEmpleoDto>> buscarPorIdEmpresa(@RequestHeader("authorization") String autorizacion,
                                                                     @PathVariable int id) {
        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<OfertaEmpleoDto> resultado = ofertaEmpleoService.buscarPorIdEmpresa(id);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/buscarporidusuario/{id}")
    public ResponseEntity<List<OfertaEmpleoDto>> buscarPorIdUsuario(@RequestHeader("authorization") String autorizacion,
                                                                     @PathVariable int id) {
        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<OfertaEmpleoDto> resultado = ofertaEmpleoService.buscarPorIdUsuario(id);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/creaoferta")
    public ResponseEntity<OfertaEmpleoDto> crearOferta(@RequestHeader("authorization") String autorizacion,
                                                       @RequestBody OfertaEmpleo ofertaEmpleo) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        OfertaEmpleoDto resultado = ofertaEmpleoService.crearOfertaEmpleo(ofertaEmpleo);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @Transactional
    @PostMapping("/actualizarOferta/{id}")
    public ResponseEntity<OfertaEmpleoDto> actualizarOferta(@RequestHeader("authorization") String autorizacion,
                                                            @PathVariable int id,
                                                            @RequestBody OfertaEmpleo ofertaEmpleo) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        OfertaEmpleoDto resultado = ofertaEmpleoService.actualizarOferta(id, ofertaEmpleo);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @Transactional
    @PostMapping("/inscribirusuario/{id}")
    public ResponseEntity<OfertaEmpleoDto> actualizarOferta(@RequestHeader("authorization") String autorizacion,
                                                            @PathVariable int id,
                                                            @RequestBody PerfilUsuario perfilUsuario) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        OfertaEmpleoDto resultado = ofertaEmpleoService.agregarTrabajador(id, perfilUsuario);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarOferta/{id}")
    public ResponseEntity<Void> borrarOfertaEmpleo(@RequestHeader("authorization") String autorizacion, @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        ofertaEmpleoService.borrarOferta(id);
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
