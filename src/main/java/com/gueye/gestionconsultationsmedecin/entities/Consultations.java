package com.gueye.gestionconsultationsmedecin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consultations {
    @Id
    private int numconsultation;
    private int numticket;
    private Date date;
    private String nom;
    private String prenom;
    private int age;
    private int montant;
}
