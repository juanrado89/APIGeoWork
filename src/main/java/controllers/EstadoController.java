package controllers;

import dtos.EstadoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AutenticacionService;
import services.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoService estadoService;
    private final AutenticacionService autenticacionService;

    public EstadoController(EstadoService estadoService, AutenticacionService autenticacionService) {
        this.estadoService = estadoService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscarestadoporid/{id}")
    public ResponseEntity<EstadoDto> buscarEstadoPorId(@RequestHeader("authorization") String autorizacion, @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        EstadoDto resultado = estadoService.buscarEstadoPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarestadopornombre/{nombre}")
    public ResponseEntity<EstadoDto> buscarEstadoPorNombre(@RequestHeader("authorization") String autorizacion, @PathVariable String nombre){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        EstadoDto resultado = estadoService.buscarEstadoPorNombre(nombre);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
