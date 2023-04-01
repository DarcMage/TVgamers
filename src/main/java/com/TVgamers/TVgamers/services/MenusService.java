package com.TVgamers.TVgamers.services;

import com.TVgamers.TVgamers.controllers.dto.MenusDto;
import com.TVgamers.TVgamers.services.repository.MenusRepository;
import com.TVgamers.TVgamers.models.MenusEntity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MenusService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MenusRepository repository;

    public List<MenusDto> getAll() { //<<<--------- Aqui dijo que no era con el Entity dijo con el Dto X reglas del estandar
        try {
            return repository.findAll()
                    .stream()
                    .map(x -> modelMapper
                            .map(x, MenusDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex){
            return null;
        }
    }
    public MenusDto saveMenus(MenusDto registro){
        try{

            /*AQUI SE ESTA PARCEANDO UN DTO A UNA IDENTIDAD*/
            return this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, MenusEntity.class)
                    ), MenusDto.class);
        }catch (Exception ex){
            return null;
        }
    }
    public Boolean deleteMenus (UUID codigo){
        try{
            Optional<MenusEntity> user=
                    repository.findById(codigo);
            if(user.isPresent()){
                repository.delete(user.get());
                return true;
            }
            return false;
        }catch (Exception ex){
            return false;
        }
    }
}
