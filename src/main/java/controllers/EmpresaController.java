package controllers;

import dtos.EmpresaDto;
import entities.Empresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AutenticacionService;
import services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;
    private final AutenticacionService autenticacionService;

    public EmpresaController(EmpresaService empresaService, AutenticacionService autenticacionService) {
        this.empresaService = empresaService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @PostMapping("/crearempresa")
    public ResponseEntity<EmpresaDto> crearEmpresa(@RequestHeader("authorization") String autorizacion, @RequestParam Empresa empresa){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        EmpresaDto resultado = empresaService.crearEmpresa(empresa);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarEmpresa/{id}")
    public ResponseEntity<EmpresaDto> buscarEmpresaPorId(@RequestHeader("authorization") String autorizacion, @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        EmpresaDto resultado = empresaService.buscarEmpresaPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizarempresa/{id}")
    public ResponseEntity<EmpresaDto> actualizarEmpresa(@RequestHeader("authorization") String autorizacion, @PathVariable int id,@RequestParam Empresa empresa){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        EmpresaDto resultado = empresaService.actualizarEmpresa(id,empresa);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarempresa/{id}")
    public ResponseEntity<Void> borrarEmpresa(@RequestHeader("authorization") String autorizacion, @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        empresaService.borrarEmpresa(id);
        return ResponseEntity.noContent().build();
    }

}
