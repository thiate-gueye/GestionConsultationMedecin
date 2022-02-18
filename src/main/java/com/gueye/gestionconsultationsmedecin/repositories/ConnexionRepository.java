package com.gueye.gestionconsultationsmedecin.repositories;

import com.gueye.gestionconsultationsmedecin.entities.Connexion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnexionRepository extends JpaRepository<Connexion,String> {
}
