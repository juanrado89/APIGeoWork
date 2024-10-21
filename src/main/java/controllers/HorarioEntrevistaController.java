package controllers;

import dtos.HorarioEntrevistaDto;
import entities.HorarioEntrevista;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.HorarioEntrevistaService;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioEntrevistaController {
    HorarioEntrevistaService horarioEntrevistaService;

    public HorarioEntrevistaController(HorarioEntrevistaService horarioEntrevistaService) {
        this.horarioEntrevistaService = horarioEntrevistaService;
    }

    @GetMapping("/buscarporidhorario/{id}")
    public ResponseEntity<HorarioEntrevistaDto> buscarPorId(@PathVariable int id) {
        HorarioEntrevistaDto resultado = horarioEntrevistaService.buscarPorId(id);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarporidoferta/{id}")
    public ResponseEntity<List<HorarioEntrevistaDto>> buscarPorIdOferta(@PathVariable int id) {
        List<HorarioEntrevistaDto> resultado = horarioEntrevistaService.buscarPorIdOferta(id);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarporparametros")
    public ResponseEntity<List<HorarioEntrevistaDto>> buscarPorParametros(@RequestParam HorarioEntrevista parametros) {
        List<HorarioEntrevistaDto> resultado = horarioEntrevistaService.buscarPorParametros(parametros);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearhorario")
    public ResponseEntity<HorarioEntrevistaDto> crearHorario(@RequestParam HorarioEntrevista horarioEntrevista) {
        HorarioEntrevistaDto resultado = horarioEntrevistaService.crearHorarioEntrevista(horarioEntrevista);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearvarioshorarios")
    public ResponseEntity<List<HorarioEntrevistaDto>> crearHorarios(@RequestParam List<HorarioEntrevista> horariosEntrevista) {
        List<HorarioEntrevistaDto> resultado = horarioEntrevistaService.crearHorariosEntrevista(horariosEntrevista);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/actualizarHorario/{id}")
    public ResponseEntity<HorarioEntrevistaDto> actualizarHorario(@PathVariable int id, @RequestParam HorarioEntrevista horarioEntrevista) {
        HorarioEntrevistaDto resultado = horarioEntrevistaService.actualizarHorario(id, horarioEntrevista);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/borrarhorario/{id}")
    public ResponseEntity<Void> borrarHorario(@PathVariable int id) {
        horarioEntrevistaService.borrarHorario(id);
        return ResponseEntity.noContent().build();
    }
}
