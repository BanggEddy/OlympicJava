package fr.efrei.test.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Evenement")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(name = "type_sport", nullable = false)
    private String typeSport;

    @Column(nullable = false)
    private String lieu;

    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;

    @Column(name = "date_fin", nullable = false)
    private Date dateFin;

    @Column(nullable = false)
    private String description;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

    @CreationTimestamp
	@Column(updatable = false, name = "created_at")
	private Date createdAt;

    @OneToMany(mappedBy = "evenement")
    private Set<Epreuve> epreuves = new HashSet<>();

    public Evenement() {
    }

    public Evenement(String nom, String typeSport, String lieu, Date dateDebut, Date dateFin, String description) {
        this.nom = nom;
        this.typeSport = typeSport;
        this.lieu = lieu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
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

    public String getTypeSport() {
        return typeSport;
    }

    public void setTypeSport(String typeSport) {
        this.typeSport = typeSport;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Epreuve> getEpreuves() {
        return epreuves;
    }

    public void setEpreuves(Set<Epreuve> epreuves) {
        this.epreuves = epreuves;
    }
}
