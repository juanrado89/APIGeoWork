package controllers;

import dtos.OfertaEmpleoDto;
import entities.OfertaEmpleo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.OfertaEmpleoService;

import java.util.List;

@RestController
@RequestMapping("/ofertadeempleo")
public class OfertaEmpleoController {

    OfertaEmpleoService ofertaEmpleoService;

    public OfertaEmpleoController(OfertaEmpleoService ofertaEmpleoService) {
        this.ofertaEmpleoService = ofertaEmpleoService;
    }

    @GetMapping("/buscarofertaporid/{id}")
    public ResponseEntity<OfertaEmpleoDto> buscarPorId(@PathVariable int id) {
        OfertaEmpleoDto resultado = ofertaEmpleoService.buscarPorId(id);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarporparametros/")
    public ResponseEntity<List<OfertaEmpleoDto>> buscarPorParametros(@RequestParam OfertaEmpleo parametros) {
        List<OfertaEmpleoDto> resultado = ofertaEmpleoService.buscarPorParametros(parametros);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creaoferta")
    public ResponseEntity<OfertaEmpleoDto> crearOferta(@RequestParam OfertaEmpleo ofertaEmpleo) {
        OfertaEmpleoDto resultado = ofertaEmpleoService.crearOfertaEmpleo(ofertaEmpleo);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizarOferta/{id}")
    public ResponseEntity<OfertaEmpleoDto> actualizarOferta(@PathVariable int id, @RequestParam OfertaEmpleo ofertaEmpleo) {
        OfertaEmpleoDto resultado = ofertaEmpleoService.actualizarOferta(id, ofertaEmpleo);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarOferta/{id}")
    public ResponseEntity<Void> borrarOfertaEmpleo(@PathVariable int id) {
        ofertaEmpleoService.borrarOferta(id);
        return ResponseEntity.noContent().build();
    }
}
