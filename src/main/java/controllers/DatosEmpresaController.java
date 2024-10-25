package controllers;

import dtos.DatosEmpresaDto;
import entities.DatosEmpresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.DatosEmpresaService;

@RestController
@RequestMapping("/datosempresa")
public class DatosEmpresaController {

    private final DatosEmpresaService datosEmpresaService;

    public DatosEmpresaController(DatosEmpresaService datosEmpresaService) {
        this.datosEmpresaService = datosEmpresaService;
    }

    @GetMapping("/buscardatosempresaporid/{id}")
    public ResponseEntity<DatosEmpresaDto> buscarDatosEmpresaPorId(@PathVariable int id){
        DatosEmpresaDto resultado = datosEmpresaService.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creardatosempresa")
    public ResponseEntity<DatosEmpresaDto> crearDatosEmpresa(@RequestParam DatosEmpresa datosEmpresa){
        DatosEmpresaDto resultado = datosEmpresaService.crearDatosEmpresa(datosEmpresa);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizardatosempresa/{id}")
    public ResponseEntity<DatosEmpresaDto> actualizarDatosEmpresa(@PathVariable int id, @RequestParam DatosEmpresa datosEmpresa){
        DatosEmpresaDto resultado = datosEmpresaService.actualizarDatosEmpresa(id,datosEmpresa);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrardatosempresa/{id}")
    public ResponseEntity<Void> borrarDatosEmpresa(@PathVariable int id){
        datosEmpresaService.borrarDatosEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
