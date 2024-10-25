package controllers;

import dtos.DescripcionExperienciaDto;
import entities.DescripcionExperiencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.DescripcionExperienciaSerice;

@RestController
@RequestMapping("/descripcionexperiencia")
public class DescripcionExperienciaController {

    private final DescripcionExperienciaSerice descripcionExperienciaSerice;

    public DescripcionExperienciaController(DescripcionExperienciaSerice descripcionExperienciaSerice) {
        this.descripcionExperienciaSerice = descripcionExperienciaSerice;
    }

    @GetMapping("/buscardescripcionexperienciaporid/{id}")
    public ResponseEntity<DescripcionExperienciaDto> buscarDescripcionExperienciaPorId(@PathVariable int id){
        DescripcionExperienciaDto resultado = descripcionExperienciaSerice.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creardescripcionexperiencia")
    public ResponseEntity<DescripcionExperienciaDto> crearDescripcionExperiencia(@RequestParam DescripcionExperiencia descripcionExperiencia){
        DescripcionExperienciaDto resultado = descripcionExperienciaSerice.crearDescripcionExperiencia(descripcionExperiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizardescripcionexperiencia/{id}")
    public ResponseEntity<DescripcionExperienciaDto> actualizarDescripcionExperiencia(@PathVariable int id, @RequestParam DescripcionExperiencia descripcionExperiencia){
        DescripcionExperienciaDto resultado = descripcionExperienciaSerice.actualizarDescripcionExperiencia(id,descripcionExperiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrardescripcionexperiencia/{id}")
    public ResponseEntity<Void> borrarDescripcionExperiencia(@PathVariable int id){
        descripcionExperienciaSerice.borrarDescripcionExperiencia(id);
        return ResponseEntity.noContent().build();
    }
}
