package com.TVgamers.TVgamers.controllers;

import com.TVgamers.TVgamers.controllers.dto.Usuariodto;
import com.TVgamers.TVgamers.controllers.dto.UsuarioLoginResponse;
import com.TVgamers.TVgamers.controllers.dto.UsuariodtoPost;
import com.TVgamers.TVgamers.controllers.dto.UsuarioLoginDto;

import com.TVgamers.TVgamers.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/usuario/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.POST})
public class UsuarioController {
    @Autowired
    UsuarioService service;
    @GetMapping()
    public ResponseEntity<List<Usuariodto>> getAll() {
        try {
            return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    // Example si queremos traer UN USUARIO
    // localhost:8080/v1/usuarios/codusu

    @PostMapping()
    public ResponseEntity<Usuariodto> save(@RequestBody UsuariodtoPost dto){
        try {
            System.out.println(dto);
            return new ResponseEntity<>(service.save(dto),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    /*@PostMapping("/login")
    public ResponseEntity<UsuarioLoginResponse> login(@RequestBody UsuarioLoginDto dto){
        return new ResponseEntity<UsuarioLoginResponse>(service.login(
                dto.getUsuario(),
                dto.getPass()),HttpStatus.OK);
    }
    @PostMapping("/login2")
    public ResponseEntity<String> login2(@RequestBody UsuarioLoginDto dto){
        return new ResponseEntity<>(service.findByUserAndPass(dto.getUsuario(),
                dto.getPass()),HttpStatus.OK);
    }*/
    @PutMapping()
    public ResponseEntity<Usuariodto> update(@RequestBody UsuariodtoPost dto){
        try{
            return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity delete(@PathVariable UUID codigo){
        try{
            return new ResponseEntity<>(
                    Boolean.TRUE.equals(
                            service.delete(codigo))?
                            "Registro Eliminado Correctamente":"Error al Eliminar Registro",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
