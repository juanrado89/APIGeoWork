package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.DocumentoDto;
import org.albertorado.apigeowork.entities.Documento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    private final DocumentoService documentoService;
    private final AutenticacionService autenticacionService;

    public DocumentoController(DocumentoService documentoService, AutenticacionService autenticacionService) {
        this.documentoService = documentoService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscardocumentoporid/{id}")
    public ResponseEntity<DocumentoDto> buscarDocumentoPorId(@RequestHeader("authorization") String autorizacion,
                                                             @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        DocumentoDto resultado = documentoService.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/creardocumento")
    public ResponseEntity<DocumentoDto> crearDocumento(@RequestBody Documento documento){


        DocumentoDto resultado = documentoService.crearDocumento(documento);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("actualizardocumento/{id}")
    public ResponseEntity<DocumentoDto> actualizarDocumento(@RequestHeader("authorization") String autorizacion,
                                                            @PathVariable int id,@RequestBody Documento documento){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        DocumentoDto resultado = documentoService.actualizarDocumento(id,documento);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrardocumento/{id}")
    public ResponseEntity<Void> borrarDocumento(@RequestHeader("authorization") String autorizacion,
                                                @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        documentoService.borrarDocumento(id);
        return ResponseEntity.noContent().build();
    }
}
