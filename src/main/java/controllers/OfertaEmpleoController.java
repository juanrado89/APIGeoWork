package controllers;

import dtos.OfertaEmpleoDto;
import entities.OfertaEmpleo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AutenticacionService;
import services.OfertaEmpleoService;

import java.util.List;

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

    @GetMapping("/buscarporparametros/")
    public ResponseEntity<List<OfertaEmpleoDto>> buscarPorParametros(@RequestHeader("authorization") String autorizacion, @RequestParam OfertaEmpleo parametros) {

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

    @PostMapping("/creaoferta")
    public ResponseEntity<OfertaEmpleoDto> crearOferta(@RequestHeader("authorization") String autorizacion, @RequestParam OfertaEmpleo ofertaEmpleo) {

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

    @PutMapping("/actualizarOferta/{id}")
    public ResponseEntity<OfertaEmpleoDto> actualizarOferta(@RequestHeader("authorization") String autorizacion, @PathVariable int id, @RequestParam OfertaEmpleo ofertaEmpleo) {

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

    @DeleteMapping("/borrarOferta/{id}")
    public ResponseEntity<Void> borrarOfertaEmpleo(@RequestHeader("authorization") String autorizacion, @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        ofertaEmpleoService.borrarOferta(id);
        return ResponseEntity.noContent().build();
    }
}
