package com.TVgamers.TVgamers.controllers.dto;

import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UsuariodtoPost {
    private UUID codigo;
    private String usuario;
    private String password;
    private String nombre;
    private String email;
    private Integer level;
}
