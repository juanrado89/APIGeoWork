package controllers;

import dtos.ExperienciaTotalDto;
import entities.ExperienciaTotal;
import services.ExperienciaTotalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("experienciatotal")
public class ExperienciaTotalController {

    private final ExperienciaTotalService experienciaTotalService;

    public ExperienciaTotalController(ExperienciaTotalService experienciaTotalService) {
        this.experienciaTotalService = experienciaTotalService;
    }

    @GetMapping("/buscaresperienciatotalporid/{id}")
    public ResponseEntity<ExperienciaTotalDto> buscarPorId(@PathVariable int id) {

        ExperienciaTotalDto resultado = experienciaTotalService.buscarPorId(id);
        if(resultado != null) {
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearexperienciatotal")
    public ResponseEntity<ExperienciaTotalDto> crearExperienciaTotal(@RequestParam ExperienciaTotal experienciaTotal) {

        ExperienciaTotalDto resultado = experienciaTotalService.crearExperiencia(experienciaTotal);
        if(resultado != null) {
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizarexperiencia/{id}")
    public ResponseEntity<ExperienciaTotalDto> actualizarExperiencia(@PathVariable int id,@RequestParam ExperienciaTotal experiencia){
        ExperienciaTotalDto resultado = experienciaTotalService.actualizarExperiencia(id,experiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarexperienciatotal/{id}")
    public ResponseEntity<Void> borrarExperiencia(@PathVariable int id){
        experienciaTotalService.borrarExperiencia(id);
        return ResponseEntity.noContent().build();
    }
}
