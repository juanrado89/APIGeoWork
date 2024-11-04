package org.albertorado.apigeowork.controllers;

import org.albertorado.apigeowork.dtos.SectorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.albertorado.apigeowork.services.AutenticacionService;
import org.albertorado.apigeowork.services.SectorService;

@RestController
@RequestMapping("/sector")
public class SectorController {

    private final SectorService sectorService;
    private final AutenticacionService autenticacionService;

    public SectorController(SectorService sectorService, AutenticacionService autenticacionService) {
        this.sectorService = sectorService;
        this.autenticacionService = autenticacionService;
    }

    private boolean validarToken(String autorizacion) {
        String token = autorizacion.replace("Bearer ", "");
        return autenticacionService.validarToken(token);
    }

    @GetMapping("/buscarsectorporid/{id}")
    public ResponseEntity<SectorDto> buscarSectorPorId(@RequestHeader("authorization") String autorizacion,
                                                       @PathVariable int id){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        SectorDto resultado = sectorService.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarsectorpornombre/{sector}")
    public ResponseEntity<SectorDto> buscarSectorPorNombre(@RequestHeader("authorization") String autorizacion,
                                                           @PathVariable String sector){

        if (!validarToken(autorizacion)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        SectorDto resultado = sectorService.buscarPorNombre(sector);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
