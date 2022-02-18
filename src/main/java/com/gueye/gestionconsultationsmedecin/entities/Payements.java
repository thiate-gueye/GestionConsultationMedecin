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
public class Payements {
    @Id
    private int numpayement;
    private Date date;
    private int numticket;
    private String nom;
    private String prenom;
    private int montant;
}
