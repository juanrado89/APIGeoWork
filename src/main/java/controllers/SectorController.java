package controllers;

import dtos.FotoDto;
import dtos.SectorDto;
import entities.Foto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.SectorService;

@RestController
@RequestMapping("/sector")
public class SectorController {

    private final SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("/buscarsectorporid/{id}")
    public ResponseEntity<SectorDto> buscarSectorPorId(@PathVariable int id){
        SectorDto resultado = sectorService.buscarPorId(id);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarsectorpornombre/{nombre}")
    public ResponseEntity<SectorDto> buscarSectorPorNombre(@PathVariable String sector){
        SectorDto resultado = sectorService.buscarPorNombre(sector);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
