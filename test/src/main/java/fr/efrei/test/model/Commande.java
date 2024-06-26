package fr.efrei.test.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Commande")
public class Commande {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false)
	private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "billet_id")
    private Billet billet;

    public Commande() {}

    public Commande(User user, Billet billet) {
        this.user = user;
        this.billet = billet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }
}
