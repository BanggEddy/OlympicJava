package fr.efrei.test.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Epreuve")
public class Epreuve {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
	private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
