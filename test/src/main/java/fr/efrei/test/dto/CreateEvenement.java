package fr.efrei.test.dto;

import java.util.Date;

public class CreateEvenement {

    private String nom;
    private String typeSport;
    private String lieu;
    private Date dateDebut;
    private Date dateFin;
    private String description;

    public CreateEvenement(String nom, String typeSport, String lieu, Date dateDebut, Date dateFin, String description) {
        this.nom = nom;
        this.typeSport = typeSport;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getTypeSport() {
        return typeSport;
    }

    public String getLieu() {
        return lieu;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getDescription() {
        return description;
    }
}
