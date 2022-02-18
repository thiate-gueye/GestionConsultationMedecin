package com.gueye.gestionconsultationsmedecin.controllers;

import com.gueye.gestionconsultationsmedecin.entities.Consultations;
import com.gueye.gestionconsultationsmedecin.entities.Patients;
import com.gueye.gestionconsultationsmedecin.entities.Payements;
import com.gueye.gestionconsultationsmedecin.repositories.ConsultationsRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.Console;
import java.util.List;

@RestController
public class ConsultationsController {
    private final ConsultationsRepository consultationsRepository;
    private RestTemplate restTemplate;

    public ConsultationsController(RestTemplateBuilder restTemplateBuilder, ConsultationsRepository consultationsRepository) {
        this.consultationsRepository = consultationsRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping(path = "/consultations")
    public List<Consultations> getlistes(){
        return consultationsRepository.findAll();
    }

    @GetMapping(path = "/consultations/{id}")
    public Consultations getConsultation(@PathVariable(value = "id") int numconsultation){
        return consultationsRepository.findById(numconsultation);
    }

    @PostMapping(path = "/consultations")
    public Consultations save(@RequestBody Consultations consultations){
        Patients patients = restTemplate.getForObject("http://localhost:8081/patients/" +
                consultations.getNumticket(), Patients.class);
        consultations.setNom(patients.getNom());
        consultations.setPrenom((patients.getPrenom()));
        consultations.setAge(patients.getAge());

        Payements payements = getPayement(consultations);
        consultations.setMontant(payements.getMontant());
        return consultationsRepository.save(consultations);
    }

    @PutMapping(path = "/consultations/{id}")
    public Consultations update(@PathVariable(value = "id") int numconsultation,@RequestBody Consultations consultations){
        consultations.setNumconsultation(numconsultation);
        Patients patients = restTemplate.getForObject("http://localhost:8081/patients/" +
                consultations.getNumticket(), Patients.class);
        consultations.setNom(patients.getNom());
        consultations.setPrenom((patients.getPrenom()));
        consultations.setAge(patients.getAge());

        Payements payements = getPayement(consultations);
        consultations.setMontant(payements.getMontant());
        return consultationsRepository.save(consultations);
    }

    @DeleteMapping(path = "/consultations/{id}")
    public void delete(@PathVariable(value = "id") int numconsultation){
        consultationsRepository.deleteById(numconsultation);
    }

    private Payements getPayement(Consultations consultations){
        Payements[] listepayements = restTemplate.getForObject("http://localhost:8082/payements/",
                Payements[].class);

        for(int i =0; i<listepayements.length; i++)
        {
            if(listepayements[i].getNumticket() == consultations.getNumticket())
                return listepayements[i];
        }
        return null;
    }
}
