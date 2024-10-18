package controllers;

import dtos.EmpresaDto;
import entities.Empresa;
import entities.Trabajador;
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
    public ResponseEntity<EmpresaDto> crearTrabajador(@RequestParam Empresa empresa){
        EmpresaDto resultado = empresaService.crearEmpresa(empresa);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarEmpresa/{id}")
    public ResponseEntity<EmpresaDto> buscarTrabajadorPorId(@PathVariable int id){
        EmpresaDto resultado = empresaService.buscarEmpresaPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actualizartrabajador/{id}")
    public ResponseEntity<EmpresaDto> actualizarEmpresa(@PathVariable int id,@RequestParam Empresa empresa){
        EmpresaDto resultado = empresaService.actualizarEmpresa(id,empresa);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrartrabajador/{id}")
    public ResponseEntity<Void> borrarEmpresa(@PathVariable int id){
        empresaService.borrarEmpresa(id);
        return ResponseEntity.noContent().build();
    }

}
