package fr.efrei.test.dto.epreuve;

import java.time.LocalDateTime;
import java.util.Date;

import fr.efrei.test.model.Evenement;

public class CreateEpreuve {
    
    private String nom;
    private Date date;
    private String stade;
    private String horraire;
    private Date updateAt;
    private Date createAt;
    private Evenement evenement;

    public CreateEpreuve(String nom, Date date, String stade, String horraire, Date updateAt, Date createAt, Evenement evenement) {
        this.nom = nom;
        this.date = date;
        this.stade = stade;
        this.horraire = horraire;
        this.updateAt = updateAt;
        this.createAt = createAt;
        this.evenement = evenement;
    }

     public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public String getStade() {
        return stade;
    }

    public String getHorraire() {
        return horraire;
    }

    public Evenement getEvenement() {
        return evenement;
    }
    public Date getUpdateAt() {
        return updateAt;
    }
    
    public Date getCreateAt() {
        return createAt;
    }
    
}
