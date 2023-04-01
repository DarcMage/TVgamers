package com.TVgamers.TVgamers.services.repository;

import com.TVgamers.TVgamers.models.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

    /*@Query("SELECT u FROM UsuarioEntity u WHERE u.user=?1 AND u.pass=?2")
    UsuarioEntity login(String user, String pass);*/

    UsuarioEntity findByNombreAndPassword(String usuario, String password);
    UsuarioEntity findByUsuario(String usuario);

}