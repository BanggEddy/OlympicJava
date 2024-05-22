package fr.efrei.test.dto.billet;

import fr.efrei.test.model.Epreuve;
import fr.efrei.test.model.User;

import java.util.Date;

public class CreateBillet {

    private Float prix;
    private Float quantity;
    private Float reduction;
    private User user;
    private Date createdAt;
    private Epreuve epreuve;

    public CreateBillet(Float prix, Float quantity, Float reduction, User user, Epreuve epreuve, Date createdAt) {
        this.prix = prix;
        this.quantity = quantity;
        this.reduction = reduction;
        this.user = user;
        this.epreuve = epreuve;
        this.createdAt = createdAt;
    }

    public Float getPrix() {
        return prix;
    }

    public Float getQuantity() {
        return quantity;
    }

    public Float getReduction() {
        return reduction;
    }

    public User getUser() {
        return user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public void setReduction(Float reduction) {
        this.reduction = reduction;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }
}
