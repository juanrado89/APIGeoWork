package controllers;

import dtos.EmpresaDto;
import entities.Empresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping("/crearempresa")
    public ResponseEntity<EmpresaDto> crearEmpresa(@RequestParam Empresa empresa){
        EmpresaDto resultado = empresaService.crearEmpresa(empresa);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarEmpresa/{id}")
    public ResponseEntity<EmpresaDto> buscarEmpresaPorId(@PathVariable int id){
        EmpresaDto resultado = empresaService.buscarEmpresaPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizarempresa/{id}")
    public ResponseEntity<EmpresaDto> actualizarEmpresa(@PathVariable int id,@RequestParam Empresa empresa){
        EmpresaDto resultado = empresaService.actualizarEmpresa(id,empresa);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarempresa/{id}")
    public ResponseEntity<Void> borrarEmpresa(@PathVariable int id){
        empresaService.borrarEmpresa(id);
        return ResponseEntity.noContent().build();
    }

}
