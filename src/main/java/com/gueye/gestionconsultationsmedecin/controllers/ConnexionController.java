package com.gueye.gestionconsultationsmedecin.controllers;

import com.gueye.gestionconsultationsmedecin.entities.Connexion;
import com.gueye.gestionconsultationsmedecin.repositories.ConnexionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConnexionController {
    private final ConnexionRepository connexionRepository;

    public ConnexionController(ConnexionRepository connexionRepository) {
        this.connexionRepository = connexionRepository;
    }

    @GetMapping(path = "/connexion/{login}/{password}")
    public  boolean  verifier(@PathVariable String login, @PathVariable String  password)
    {
        List<Connexion> connexions = connexionRepository.findAll();
        for(Connexion con : connexions)
        {
            if(con.getLogin().equals(login) && con.getPassword().equals(password))
                return true;
        }
        return false;
    }

}
