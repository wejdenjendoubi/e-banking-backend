package com.example.ebankig.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;


@Entity
public class Mondat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String compteDestinataire;
    private Double montant;
    private int codeRetrait;

    private String numCompte; // Add this for sending the account number in requests

    @ManyToOne
    @JoinColumn(name = "compte_id", referencedColumnName = "numCompte")
    private Compte compte;

    // Default constructor
    public Mondat() {}

    // Constructor with all fields
    public Mondat(Long id, String compteDestinataire, Double montant, int codeRetrait, String numCompte, Compte compte) {
        this.id = id;
        this.compteDestinataire = compteDestinataire;
        this.montant = montant;
        this.codeRetrait = codeRetrait;
        this.numCompte = numCompte;
        this.compte = compte;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompteDestinataire() {
        return compteDestinataire;
    }

    public void setCompteDestinataire(String compteDestinataire) {
        this.compteDestinataire = compteDestinataire;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public int getCodeRetrait() {
        return codeRetrait;
    }

    public void setCodeRetrait(int codeRetrait) {
        this.codeRetrait = codeRetrait;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Mondat{" +
                "id=" + id +
                ", compteDestinataire='" + compteDestinataire + '\'' +
                ", montant=" + montant +
                ", codeRetrait=" + codeRetrait +
                ", numCompte='" + numCompte + '\'' +
                ", compte=" + (compte != null ? compte.getNumCompte() : null) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mondat)) return false;
        Mondat mondat = (Mondat) o;
        return Objects.equals(id, mondat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
