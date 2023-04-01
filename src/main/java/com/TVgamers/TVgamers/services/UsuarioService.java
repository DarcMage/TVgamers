package com.TVgamers.TVgamers.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TVgamers.TVgamers.controllers.dto.Usuariodto;
import com.TVgamers.TVgamers.controllers.dto.UsuariodtoPost;
import com.TVgamers.TVgamers.controllers.dto.UsuarioLoginResponse;
import com.TVgamers.TVgamers.models.UsuarioEntity;
import com.TVgamers.TVgamers.services.repository.UsuarioRepository;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UsuarioService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuariodto> getAll() { //<<<--------- Aqui dijo que no era con el Entity dijo con el Dto X reglas del estandar
        try {
            return usuarioRepository.findAll()
                    .stream()
                    .map(x -> modelMapper
                            .map(x, Usuariodto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public Usuariodto save(UsuariodtoPost user){
        try{
            System.out.println(user);
            /*AQUI SE ESTA PARCEANDO UN DTO A UNA IDENTIDAD*/
            return this.modelMapper.map(
                    usuarioRepository.save(
                            this.modelMapper.map(user, UsuarioEntity.class)
                    ),Usuariodto.class);
        }catch (Exception ex){
            System.out.println("error");
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public Boolean delete(UUID codigo){
        try{
            Optional<UsuarioEntity> user=
                    usuarioRepository.findById(codigo);
            if(user.isPresent()){
                usuarioRepository.delete(user.get());
                return true;
            }
            return false;
        }catch (Exception ex){
            return false;
        }
    }
  /*  public UsuarioLoginResponse login (String user, String pass){
        UsuarioLoginResponse response= new UsuarioLoginResponse();
        response.setCodigo(400);
        try{

            UsuarioEntity usuariouser=usuarioRepository.findByUsuario(user);
            if(usuariouser==null){
                response.setMensaje("Usuario no existe");
                response.setToken("");
                return response;
            }
            System.out.println(usuariouser);

            /*UsuarioEntity UsuarioEntity=Usuariodto.login(nom_usu,password);
            log.info("Usuario",UsuarioEntity);

            System.out.println(UsuarioEntity);*/

/*
            if(!usuariouser.getPass().equals(pass))
            {
                response.setMensaje("Usuario y Clave incorrectos");
                return response;
            }
            String datos="codigo="+usuariouser.getCodigo()+"!=!";
            datos+="usuario="+usuariouser.getUsuario()+"!=!";
            datos+="pass="+usuariouser.getPass()+"!=!";
            datos+="nombre="+usuariouser.getNombre()+"!=!";
            datos+="email="+usuariouser.getEmail()+"!=!";
            datos+="level="+usuariouser.getLevel()+"!=!";

            Base64 base64 = new Base64();
            String token=new String(base64.encode(datos.getBytes()));
            response.setCodigo(200);
            response.setMensaje("Inicio de Sesión Satisfactorio");
            response.setToken(token);
            return response;


        }catch(Exception ex){
            log.error("Error en login",ex.getCause());
            response.setMensaje("error al loguearse ->"+ex.getCause());
            response.setToken("");
            return response;
        }
    } */
   /* public String findByUserAndPass (String user, String pass){
        try{
            UsuarioEntity UsuarioEntity=usuarioRepository.findByNombreAndPass(user,pass);
            System.out.println(UsuarioEntity);
            if(UsuarioEntity.equals(null)) return null;

            String datos="codigo="+UsuarioEntity.getCodigo()+"!=!";
            datos+="usuario="+UsuarioEntity.getUsuario()+"!=!";
            datos+="pass="+UsuarioEntity.getPass()+"!=!";
            datos+="nombre="+UsuarioEntity.getNombre()+"!=!";
            datos+="email="+UsuarioEntity.getEmail()+"!=!";
            datos+="level="+UsuarioEntity.getLevel()+"!=!";

            Base64 base64 = new Base64();
            return new String(base64.encode(datos.getBytes()));
        }catch(Exception ex){
            log.error("Error en findByNombreAndPass",ex.getCause());
            return null;
        }
    }*/
}



