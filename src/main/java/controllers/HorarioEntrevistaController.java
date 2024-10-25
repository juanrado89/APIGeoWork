package controllers;

import dtos.HorarioEntrevistaDto;
import entities.HorarioEntrevista;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AutenticacionService;
import services.HorarioEntrevistaService;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioEntrevistaController {
    HorarioEntrevistaService horarioEntrevistaService;
    private final AutenticacionService autenticacionService;

    public HorarioEntrevistaController(HorarioEntrevistaService horarioEntrevistaService, AutenticacionService autenticacionService) {
        this.horarioEntrevistaService = horarioEntrevistaService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscarporidhorario/{id}")
    public ResponseEntity<HorarioEntrevistaDto> buscarPorId(@RequestHeader("authorization") String autorizacion, @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        HorarioEntrevistaDto resultado = horarioEntrevistaService.buscarPorId(id);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarporidoferta/{id}")
    public ResponseEntity<List<HorarioEntrevistaDto>> buscarPorIdOferta(@RequestHeader("authorization") String autorizacion, @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<HorarioEntrevistaDto> resultado = horarioEntrevistaService.buscarPorIdOferta(id);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarporparametros")
    public ResponseEntity<List<HorarioEntrevistaDto>> buscarPorParametros(@RequestHeader("authorization") String autorizacion, @RequestParam HorarioEntrevista parametros) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<HorarioEntrevistaDto> resultado = horarioEntrevistaService.buscarPorParametros(parametros);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearhorario")
    public ResponseEntity<HorarioEntrevistaDto> crearHorario(@RequestHeader("authorization") String autorizacion, @RequestParam HorarioEntrevista horarioEntrevista) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        HorarioEntrevistaDto resultado = horarioEntrevistaService.crearHorarioEntrevista(horarioEntrevista);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearvarioshorarios")
    public ResponseEntity<List<HorarioEntrevistaDto>> crearHorarios(@RequestHeader("authorization") String autorizacion, @RequestParam List<HorarioEntrevista> horariosEntrevista) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<HorarioEntrevistaDto> resultado = horarioEntrevistaService.crearHorariosEntrevista(horariosEntrevista);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/actualizarHorario/{id}")
    public ResponseEntity<HorarioEntrevistaDto> actualizarHorario(@RequestHeader("authorization") String autorizacion, @PathVariable int id, @RequestParam HorarioEntrevista horarioEntrevista) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        HorarioEntrevistaDto resultado = horarioEntrevistaService.actualizarHorario(id, horarioEntrevista);
        if (resultado != null) {
            return ResponseEntity.ok().body(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/borrarhorario/{id}")
    public ResponseEntity<Void> borrarHorario(@RequestHeader("authorization") String autorizacion, @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        horarioEntrevistaService.borrarHorario(id);
        return ResponseEntity.noContent().build();
    }
}
