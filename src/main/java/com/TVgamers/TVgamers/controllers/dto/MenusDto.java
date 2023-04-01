package com.TVgamers.TVgamers.controllers.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MenusDto {

    private UUID codigo;

    private String nombre;


    private String url;


    private String icono;


    private Integer orden;


    private UUID menuPadre;

}
