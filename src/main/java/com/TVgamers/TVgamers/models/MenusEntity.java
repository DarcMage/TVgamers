package com.TVgamers.TVgamers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity


@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "tbmenu", schema = "mantenimiento")
public class MenusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idMenu", nullable = false)
    private UUID codigo;
    @Column (name = "nom_dis", nullable = false)
    private String nombre;

    @Column (name = "url", nullable = false)
    private String url;

    @Column (name = "icono", nullable = false)
    private String icono;

    @Column (name = "orden", nullable = false)
    private Integer orden;

    @Column (name = "menuPadre",nullable = true)
    private UUID menuPadre=null;


}
