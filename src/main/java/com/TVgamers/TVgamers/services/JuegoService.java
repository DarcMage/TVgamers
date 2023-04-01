package com.TVgamers.TVgamers.services;

import com.TVgamers.TVgamers.models.JuegoEntity;
import com.TVgamers.TVgamers.controllers.dto.Juegodto;
import com.TVgamers.TVgamers.services.repository.JuegoRepository;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JuegoService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    JuegoRepository juegoRepository;

    public List<Juegodto> getAll() { //<<<--------- Aqui dijo que no era con el Entity dijo con el Dto X reglas del estandar
        try {
            return juegoRepository.findAll()
                    .stream()
                    .map(x -> modelMapper
                            .map(x, Juegodto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {

            log.error("Error en login",ex.getCause());
            return null;
        }
    }
    public Juegodto savej(Juegodto user){
        try{
            /*AQUI SE ESTA PARCEANDO UN DTO A UNA IDENTIDAD*/
            return this.modelMapper.map(
                    juegoRepository.save(
                            this.modelMapper.map(user, JuegoEntity.class)
                    ),Juegodto.class);
        }catch (Exception ex){
            return null;
        }
    }
    public Boolean deletej(UUID id){
        try{
            Optional<JuegoEntity> user=
                    juegoRepository.findById(id);
            if(user.isPresent()){
                juegoRepository.delete(user.get());
                return true;
            }
            return false;
        }catch (Exception ex){
            return false;
        }
    }

}
