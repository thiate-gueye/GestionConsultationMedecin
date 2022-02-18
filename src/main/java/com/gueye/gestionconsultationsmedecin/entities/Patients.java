package com.gueye.gestionconsultationsmedecin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patients {
    private int numticket;
    private String nom;
    private String prenom;
    private Date date;
    private int age;
    private int poids;
    private int temperature;
}

