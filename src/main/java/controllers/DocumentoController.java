package controllers;

import dtos.DocumentoDto;
import entities.Documento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @GetMapping("/buscardocumentoporid/{id}")
    public ResponseEntity<DocumentoDto> buscarDocumentoPorId(@PathVariable int id){
        DocumentoDto resultado = documentoService.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creardocumento")
    public ResponseEntity<DocumentoDto> crearDocumento(@RequestParam Documento documento){
        DocumentoDto resultado = documentoService.crearDocumento(documento);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizardocumento/{id}")
    public ResponseEntity<DocumentoDto> actualizarDocumento(@PathVariable int id,@RequestParam Documento documento){
        DocumentoDto resultado = documentoService.actualizarDocumento(id,documento);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrardocumento/{id}")
    public ResponseEntity<Void> borrarDocumento(@PathVariable int id){
        documentoService.borrarDocumento(id);
        return ResponseEntity.noContent().build();
    }
}
