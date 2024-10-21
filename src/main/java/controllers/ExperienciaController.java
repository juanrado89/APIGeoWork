package controllers;

import dtos.EmpresaDto;
import dtos.ExperienciaDto;
import entities.Empresa;
import entities.Experiencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ExperienciaService;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

    private final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @PostMapping("/crearexperiencia")
    public ResponseEntity<ExperienciaDto> crearExperiencia(@RequestParam Experiencia experiencia){
        ExperienciaDto resultado = experienciaService.crearExperiencia(experiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarexperiencia/{id}")
    public ResponseEntity<ExperienciaDto> buscarExperienciaPorId(@PathVariable int id){
        ExperienciaDto resultado = experienciaService.buscarExperienciaPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarexperienciaporsector/{sector}")
    public ResponseEntity<List<ExperienciaDto>> buscarExperienciaPorId(@PathVariable String sector){
        List<ExperienciaDto> resultado = experienciaService.buscarExperienciaPorSector(sector);
        if(!resultado.isEmpty()){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizarexperiencia/{id}")
    public ResponseEntity<ExperienciaDto> actualizarExperiencia(@PathVariable int id,@RequestParam Experiencia experiencia){
        ExperienciaDto resultado = experienciaService.actualizarExperiencia(id,experiencia);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarexperiencia/{id}")
    public ResponseEntity<Void> borrarExperiencia(@PathVariable int id){
        experienciaService.borrarExperiencia(id);
        return ResponseEntity.noContent().build();
    }
}
