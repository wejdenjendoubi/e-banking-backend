package com.example.ebankig.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mondat {
    @Id
    
    private Long id;

    private String compteDestinataire;
    private Double montant;
    private int codeRetrait; // 4 chiffres généré automatiquement

    @ManyToOne
    @JoinColumn(name = "compte_id", referencedColumnName = "numCompte")
    private Compte compte;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompteDestinataire() {
        return this.compteDestinataire;
    }

    public void setCompteDestinataire(String compteDestinataire) {
        this.compteDestinataire = compteDestinataire;
    }

    public Double getMontant() {
        return this.montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public int getCodeRetrait() {
        return this.codeRetrait;
    }

    public void setCodeRetrait(int codeRetrait) {
        this.codeRetrait = codeRetrait;
    }

    public Mondat() {
    }

    public Mondat(Long id, String compteDestinataire, Double montant, int codeRetrait) {
        this.id = id;
        this.compteDestinataire = compteDestinataire;
        this.montant = montant;
        this.codeRetrait = codeRetrait;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", compteDestinataire='" + getCompteDestinataire() + "'" +
            ", montant='" + getMontant() + "'" +
            ", codeRetrait='" + getCodeRetrait() + "'" +
            "}";
    }
    
    
}
