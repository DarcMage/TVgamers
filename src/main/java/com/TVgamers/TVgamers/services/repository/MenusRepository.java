package com.TVgamers.TVgamers.services.repository;

import com.TVgamers.TVgamers.models.MenusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenusRepository extends JpaRepository<MenusEntity, UUID> {
}