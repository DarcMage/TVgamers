package com.TVgamers.TVgamers.controllers;

import com.TVgamers.TVgamers.controllers.dto.MenusDto;
import com.TVgamers.TVgamers.services.MenusService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/menu/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class MenusController {
    @Autowired
    MenusService service;
    @GetMapping()
    public ResponseEntity<List<MenusDto>> getAll(){
        try{
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<MenusDto> save (@RequestBody MenusDto dto){
        try{
            return new ResponseEntity<>(service.saveMenus(dto), HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping()
    public ResponseEntity<MenusDto> update(@RequestBody MenusDto dto){
        try{
            return new ResponseEntity<>(service.saveMenus(dto), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity delete(@PathVariable UUID codigo){
        try{
            return new ResponseEntity<>(Boolean.TRUE.equals(
                    service.deleteMenus(codigo))?
                    "Registro Eliminado Correctamente":"Error al Eliminar Registro",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
