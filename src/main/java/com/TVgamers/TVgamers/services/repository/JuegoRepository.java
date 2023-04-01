package com.TVgamers.TVgamers.services.repository;

import com.TVgamers.TVgamers.models.JuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JuegoRepository extends JpaRepository<JuegoEntity, UUID> {

}