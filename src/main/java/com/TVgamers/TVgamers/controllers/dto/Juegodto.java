package com.TVgamers.TVgamers.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Juegodto {
    private UUID id;
    private String nombre;
    private Integer stock;
    private Double precio;
    private Integer id_desc;
    private Integer id_valo;
    private Integer id_imagen;
    private Integer id_cat;
    private String desp_1;
    private String desp_2;
}
