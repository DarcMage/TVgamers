package com.TVgamers.TVgamers.controllers.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Usuariodto {

    private UUID codigo;
    private String usuario;
    private String password;
    private String nombre;
    private String email;
    private Integer level;
}
