package fr.efrei.test.model;

import jakarta.persistence.*;

import java.util.Date;
import org.hibernate.annotations.UpdateTimestamp;

import fr.efrei.test.constants.Role;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
	private String fullName;

	@Column(unique = true, length = 100, nullable = false)
	private String email;
    
    @Column(nullable = false)
	private String password;
    
	@CreationTimestamp
	@Column(updatable = false, name = "created_at")
	private Date createdAt;

    @UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	@Enumerated(EnumType.STRING)
	private Role role;

    public User() {}

    public User(Long id, String nom, String email, Role role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
