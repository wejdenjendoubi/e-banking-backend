package com.example.ebankig.model;

import java.math.BigDecimal;
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
    private BigDecimal solde;

    // Plusieurs comptes appartiennent à un user
    @ManyToOne
    @JoinColumn(name = "user_login")
    private User user;

    // Un compte peut avoir plusieurs opérations
    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
   
   
    private List<Operation> operations;

    public Compte() {}

    

    public Compte(String numCompte, String agence, BigDecimal solde, User user, List<Operation> operations) {
        this.numCompte = numCompte;
        this.agence = agence;
        this.solde = solde;
        this.user = user;
        this.operations = operations;
    }


    public String getNumCompte() {
        return this.numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getAgence() {
        return this.agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }

    public BigDecimal getSolde() {
        return this.solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Operation> getOperations() {
        return this.operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    
}
