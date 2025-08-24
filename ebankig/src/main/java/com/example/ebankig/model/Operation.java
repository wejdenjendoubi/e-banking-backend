package com.example.ebankig.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;

    private String libelle;

    private String type;  // ex: DEPOT, RETRAIT, VIREMENT
    private LocalDateTime dateOperation;
    private String statut; // ex: EN_ATTENTE, VALIDEE, REJETEE

    @ManyToOne
    @JoinColumn(name = "compte_id", referencedColumnName = "numCompte")
    private Compte compte;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDateTime getDateOperation() { return dateOperation; }
    public void setDateOperation(LocalDateTime dateOperation) { this.dateOperation = dateOperation; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Compte getCompte() { return compte; }
    public void setCompte(Compte compte) { this.compte = compte; }
}
