package com.TVgamers.TVgamers.controllers;

import com.TVgamers.TVgamers.controllers.dto.Juegodto;
import com.TVgamers.TVgamers.models.JuegoEntity;
import com.TVgamers.TVgamers.services.repository.JuegoRepository;
import com.TVgamers.TVgamers.services.JuegoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/v1/juego/")
public class JuegoController {

    @Autowired
    JuegoService service;

    @GetMapping()
    public ResponseEntity<List<Juegodto>> getAll() {
        try {
            return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<Juegodto> update(@RequestBody Juegodto dto){
        try{
            return new ResponseEntity<>(service.savej(dto), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Juegodto> savej(@RequestBody Juegodto dto){
        try {
            System.out.println(dto);
            return new ResponseEntity<>(service.savej(dto),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletej(@PathVariable UUID id){
        try{
            return new ResponseEntity<>(
                    Boolean.TRUE.equals(
                            service.deletej(id))?
                            "Registro Eliminado Correctamente":"Error al Eliminar Registro",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
