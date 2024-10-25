package controllers;

import dtos.NivelDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AutenticacionService;
import services.NivelService;

@RestController
@RequestMapping("/nivel")
public class NivelController {

    private final NivelService nivelService;
    private final AutenticacionService autenticacionService;

    public NivelController(NivelService nivelService, AutenticacionService autenticacionService) {
        this.nivelService = nivelService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscarporid/{id}")
    public ResponseEntity<NivelDto> buscarPorId(@RequestHeader("authorization") String autorizacion, @PathVariable int id) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        NivelDto resultado = nivelService.buscarPorId(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/buscarpornombre/{nombre}")
    public ResponseEntity<NivelDto> buscarPorId(@RequestHeader("authorization") String autorizacion, @PathVariable String nombre) {

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        NivelDto resultado = nivelService.buscarPorNombre(nombre);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
