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
@Table(name = "usuario", schema = "mantenimiento")
public class UsuarioEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id_user", nullable = false)
    private UUID codigo;
    @Column (name = "usuario", nullable = false)
    private String usuario;
    @Column (name = "pass", nullable = false)
    private String pass;
    @Column (name = "nombre", nullable = false)
    private String nombre;
    @Column (name = "email", nullable = false)
    private String email;

    @Column (name = "level", nullable = false)
    private Integer level;

}
