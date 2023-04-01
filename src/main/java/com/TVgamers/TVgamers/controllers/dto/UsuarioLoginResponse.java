package com.TVgamers.TVgamers.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UsuarioLoginResponse {

        private int codigo=200;
        private String mensaje="";
        private String token="";

}
