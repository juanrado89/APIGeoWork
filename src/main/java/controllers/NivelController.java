package controllers;

import dtos.NivelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.NivelService;

@RestController
@RequestMapping("/nivel")
public class NivelController {

    private final NivelService nivelService;

    public NivelController(NivelService nivelService) {
        this.nivelService = nivelService;
    }

    @GetMapping("/buscarporid/{id}")
    public ResponseEntity<NivelDto> buscarPorId(@PathVariable int id) {

        NivelDto resultado = nivelService.buscarPorId(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/buscarpornombre/{nombre}")
    public ResponseEntity<NivelDto> buscarPorId(@PathVariable String nombre) {

        NivelDto resultado = nivelService.buscarPorNombre(nombre);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
