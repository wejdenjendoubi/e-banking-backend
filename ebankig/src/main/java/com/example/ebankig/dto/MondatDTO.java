package com.example.ebankig.dto;

public class MondatDTO {
    private Long id;
    private String compteDestinataire;
    private Double montant;
    private Integer codeRetrait; // 4 chiffres


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

    public Integer getCodeRetrait() {
        return this.codeRetrait;
    }

    public void setCodeRetrait(Integer codeRetrait) {
        this.codeRetrait = codeRetrait;
    }
    
}
