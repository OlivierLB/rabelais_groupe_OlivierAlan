/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioninscription;

import java.sql.Date;

/**
 *
 * @author alan
 */
public class session {
    private String libelle, niveau;
    private Date dateDebut;
    private int nbPlace, nbInscrit;

    public void setLibelle(String pLibelle) {
        this.libelle = pLibelle;
    }

    public void setNiveau(String pNiveau) {
        this.niveau = pNiveau;
    }

    public void setDateDebut(Date pDateDebut) {
        this.dateDebut = pDateDebut;
    }

    public void setNbPlace(int pNbPlace) {
        this.nbPlace = pNbPlace;
    }

    public void setNbInscrit(int pNbInscrit) {
        this.nbInscrit = pNbInscrit;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getNiveau() {
        return niveau;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public int getNbInscrit() {
        return nbInscrit;
    }
    
    
}
