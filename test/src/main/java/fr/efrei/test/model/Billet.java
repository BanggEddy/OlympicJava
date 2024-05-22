package fr.efrei.test.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Billet")
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String uuid;

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

    private LocalDateTime deletedAt = null;

    public Billet(Float prix, Float quantity, Float reduction, User user, Epreuve epreuve, Date createdAt) {
        this.prix = prix;
        this.quantity = quantity;
        this.reduction = reduction;
        this.user = user;
        this.epreuve = epreuve;
        this.createdAt = createdAt;
    }

    public String getId() {
        return uuid;
    }

    public void setId(String uuid) {
        this.uuid = uuid;
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

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
