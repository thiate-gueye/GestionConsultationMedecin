package com.gueye.gestionconsultationsmedecin.repositories;

import com.gueye.gestionconsultationsmedecin.entities.Consultations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationsRepository extends JpaRepository<Consultations, Integer> {
    Consultations findById(int id);
}
