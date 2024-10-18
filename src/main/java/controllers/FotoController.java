package controllers;

import dtos.FotoDto;
import entities.Foto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.FotoService;


@RestController
@RequestMapping("/foto")
public class FotoController {
    private final FotoService fotoService;

    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @GetMapping("/buscarfotoporid/{id}")
    public ResponseEntity<FotoDto> buscarDocumentoPorId(@PathVariable int id){
        FotoDto resultado = fotoService.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearfoto")
    public ResponseEntity<FotoDto> crearDocumento(@RequestParam Foto foto){
        FotoDto resultado = fotoService.crearFoto(foto);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizarfoto/{id}")
    public ResponseEntity<FotoDto> actualizarDocumento(@PathVariable int id,@RequestParam Foto foto){
        FotoDto resultado = fotoService.actualizarFoto(id,foto);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarfoto/{id}")
    public ResponseEntity<Void> borrarDocumento(@PathVariable int id){
        fotoService.borrarFoto(id);
        return ResponseEntity.noContent().build();
    }
}
