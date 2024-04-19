package fr.efrei.test.model;

import jakarta.persistence.*;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Epreuve")
public class Epreuve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String stade;

    @Column(nullable = false)
    private String horraire;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

    @CreationTimestamp
	@Column(updatable = false, name = "created_at")
	private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    public Epreuve() {
    }

    public Epreuve(String nom, Date date, String stade, String horraire, Evenement evenement) {
        this.nom = nom;
        this.date = date;
        this.stade = stade;
        this.horraire = horraire;
        this.evenement = evenement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStade() {
        return stade;
    }

    public void setStade(String stade) {
        this.stade = stade;
    }

    public String getHorraire() {
        return horraire;
    }

    public void setHorraire(String horraire) {
        this.horraire = horraire;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
}
