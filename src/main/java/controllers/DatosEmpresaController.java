package controllers;

import dtos.DatosEmpresaDto;
import entities.DatosEmpresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AutenticacionService;
import services.DatosEmpresaService;

@RestController
@RequestMapping("/datosempresa")
public class DatosEmpresaController {

    private final DatosEmpresaService datosEmpresaService;
    private final AutenticacionService autenticacionService;

    public DatosEmpresaController(DatosEmpresaService datosEmpresaService, AutenticacionService autenticacionService) {
        this.datosEmpresaService = datosEmpresaService;
        this.autenticacionService = autenticacionService;
    }


    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscardatosempresaporid/{id}")
    public ResponseEntity<DatosEmpresaDto> buscarDatosEmpresaPorId(@RequestHeader("Authorization") String autorizacion,
                                                                   @PathVariable int id) {
        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        DatosEmpresaDto resultado = datosEmpresaService.buscarPorId(id);
        return resultado != null ? ResponseEntity.ok(resultado) : ResponseEntity.notFound().build();
    }

    @PostMapping("/creardatosempresa")
    public ResponseEntity<DatosEmpresaDto> crearDatosEmpresa(@RequestHeader("Authorization") String autorizacion,
                                                             @RequestParam DatosEmpresa datosEmpresa) {
        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        DatosEmpresaDto resultado = datosEmpresaService.crearDatosEmpresa(datosEmpresa);
        return resultado != null ? ResponseEntity.ok(resultado) : ResponseEntity.notFound().build();
    }

    @PutMapping("actualizardatosempresa/{id}")
    public ResponseEntity<DatosEmpresaDto> actualizarDatosEmpresa(@RequestHeader("Authorization") String autorizacion,
                                                                  @PathVariable int id,
                                                                  @RequestParam DatosEmpresa datosEmpresa) {
        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        DatosEmpresaDto resultado = datosEmpresaService.actualizarDatosEmpresa(id, datosEmpresa);
        return resultado != null ? ResponseEntity.ok(resultado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/borrardatosempresa/{id}")
    public ResponseEntity<Void> borrarDatosEmpresa(@RequestHeader("Authorization") String autorizacion,
                                                   @PathVariable int id) {
        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        datosEmpresaService.borrarDatosEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}

