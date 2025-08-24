package com.example.ebankig.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Compte {

    @Id
    private String numCompte;   // clé primaire

    @Column(nullable = false)
    private String agence;

    // Plusieurs comptes appartiennent à un user
    @ManyToOne
    @JoinColumn(name = "user_login")
    private User user;

    // Un compte peut avoir plusieurs opérations
    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
   
   
    private List<Operation> operations;

    public Compte() {}

    public Compte(String numCompte, String agence, User user) {
        this.numCompte = numCompte;
        this.agence = agence;
        this.user = user;
    }

    // getters et setters
    public String getNumCompte() {
        return numCompte;
    }
    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getAgence() {
        return agence;
    }
    public void setAgence(String agence) {
        this.agence = agence;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<Operation> getOperations() {
        return operations;
    }
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
