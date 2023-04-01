package com.TVgamers.TVgamers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "juegos", schema = "mantenimiento")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class JuegoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "juego", nullable = false)
    private UUID id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "id_desc", nullable = false)
    private Integer id_desc;

    @Column(name = "id_valo", nullable = false)
    private Integer id_valo;

    @Column(name = "id_imagen", nullable = false)
    private Integer id_imagen;

    @Column(name = "id_cat", nullable = false)
    private Integer id_cat;

    @Column(name = "desp_1", nullable = false)
    private String desp_1;

    @Column(name = "desp_2", nullable = false)
    private String desp_2;
}
