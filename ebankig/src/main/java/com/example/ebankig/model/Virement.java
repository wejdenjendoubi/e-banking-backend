package com.example.ebankig.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Virement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // clé primaire auto

    @Column(nullable = false)
    private String motif;

    @Column(nullable = false)
    private Double montant;

    // Compte source (ManyToOne)
    @ManyToOne
    
    @JoinColumn(name = "compte_source")
    private Compte compteSource;

    // Compte bénéficiaire (ManyToOne)
    @ManyToOne
    @JoinColumn(name = "compte_beneficiaire")
    private Compte compteBeneficiaire;

    public Virement() {}

    public Virement(String motif, Double montant, Compte compteSource, Compte compteBeneficiaire) {
        this.motif = motif;
        this.montant = montant;
        this.compteSource = compteSource;
        this.compteBeneficiaire = compteBeneficiaire;
    }

    // getters et setters
    public Long getId() {
        return id;
    }

    public String getMotif() {
        return motif;
    }
    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Double getMontant() {
        return montant;
    }
    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Compte getCompteSource() {
        return compteSource;
    }
    public void setCompteSource(Compte compteSource) {
        this.compteSource = compteSource;
    }

    public Compte getCompteBeneficiaire() {
        return compteBeneficiaire;
    }
    public void setCompteBeneficiaire(Compte compteBeneficiaire) {
        this.compteBeneficiaire = compteBeneficiaire;
    }
}
