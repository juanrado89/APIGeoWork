package controllers;

import dtos.NivelEducativoDto;
import entities.NivelEducativo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.NivelEducativoService;

import java.util.List;

@RestController
@RequestMapping("/niveleducativo")
public class NivelEducativoController {

    private final NivelEducativoService nivelEducativoService;

    public NivelEducativoController(NivelEducativoService nivelEducativoService) {
        this.nivelEducativoService = nivelEducativoService;
    }


    @GetMapping("/buscarporidniveleducativo/{id}")
    public ResponseEntity<NivelEducativoDto> buscarPorId(@PathVariable int id) {
        NivelEducativoDto resultado = nivelEducativoService.buscarPorId(id);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarportitulo")
    public ResponseEntity<List<NivelEducativoDto>> buscarPortitulo(@RequestParam String titulo) {
        List<NivelEducativoDto> resultado = nivelEducativoService.buscarPortitulo(titulo);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearniveleducativo")
    public ResponseEntity<NivelEducativoDto> crearNivelEducativo(@RequestParam NivelEducativo nivelEducativo) {
        NivelEducativoDto resultado = nivelEducativoService.crearNivelEducativo(nivelEducativo);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizarniveleducativo/{id}")
    public ResponseEntity<NivelEducativoDto> actualizarHorario(@PathVariable int id, @RequestParam NivelEducativo nivelEducativo) {
        NivelEducativoDto resultado = nivelEducativoService.actualizarNivelEducativo(id, nivelEducativo);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/borrarniveleducativo/{id}")
    public ResponseEntity<Void> borrarNivelEducativo(@PathVariable int id) {
        nivelEducativoService.borrarNivelEducativo(id);
        return ResponseEntity.noContent().build();
    }
}
