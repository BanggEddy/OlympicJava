package fr.efrei.test.model;

import jakarta.persistence.*;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Billet")
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float prix;

    @Column(nullable = false)
    private Float quantity;

    @Column(nullable = true)
    private Float reduction;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	@CreationTimestamp
	@Column(updatable = false, name = "created_at")
	private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "epreuve_id")
    private Epreuve epreuve;

    // Constructor
    public Billet() {}

    public Billet(Float prix, Float quantity, Float reduction, User user, Epreuve epreuve) {
        this.prix = prix;
        this.quantity = quantity;
        this.reduction = reduction;
        this.user = user;
        this.epreuve = epreuve;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getReduction() {
        return reduction;
    }

    public void setReduction(Float reduction) {
        this.reduction = reduction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }
}

