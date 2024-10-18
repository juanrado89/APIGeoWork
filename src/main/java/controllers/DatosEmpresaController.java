package controllers;

import dtos.DatosEmpresaDto;
import dtos.DocumentoDto;
import entities.DatosEmpresa;
import entities.Documento;
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

    @GetMapping("/buscardocumentoporid/{id}")
    public ResponseEntity<DatosEmpresaDto> buscarDatosEmpresaPorId(@PathVariable int id){
        DatosEmpresaDto resultado = datosEmpresaService.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crearDocumento")
    public ResponseEntity<DatosEmpresaDto> crearDatosEmpresa(@RequestParam DatosEmpresa datosEmpresa){
        DatosEmpresaDto resultado = datosEmpresaService.crearDatosEmpresa(datosEmpresa);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizardocumento/{id}")
    public ResponseEntity<DatosEmpresaDto> actualizarDatosEmpresa(@PathVariable int id, @RequestParam DatosEmpresa datosEmpresa){
        DatosEmpresaDto resultado = datosEmpresaService.actualizarDatosEmpresa(id,datosEmpresa);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrardocumento/{id}")
    public ResponseEntity<Void> borrarDatosEmpresa(@PathVariable int id){
        datosEmpresaService.borrarDatosEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
