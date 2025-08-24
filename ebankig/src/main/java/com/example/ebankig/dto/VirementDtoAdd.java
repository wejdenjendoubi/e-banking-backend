package com.example.ebankig.dto;



public class  VirementDtoAdd {

private String compteDestination;
private String compteSource;
private Double montant;
private String motif;

    public VirementDtoAdd() {
    }


    public String getCompteDestination() {
        return this.compteDestination;
    }

    public void setCompteDestination(String compteDestination) {
        this.compteDestination = compteDestination;
    }

    public String getCompteSource() {
        return this.compteSource;
    }

    public void setCompteSource(String compteSource) {
        this.compteSource = compteSource;
    }

    public Double getMontant() {
        return this.montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return this.motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }


    public VirementDtoAdd(String compteDestination, String compteSource, Double montant, String motif) {
        this.compteDestination = compteDestination;
        this.compteSource = compteSource;
        this.montant = montant;
        this.motif = motif;
    }

    @Override
    public String toString() {
        return "{" +
            " compteDestination='" + getCompteDestination() + "'" +
            ", compteSource='" + getCompteSource() + "'" +
            ", montant='" + getMontant() + "'" +
            ", motif='" + getMotif() + "'" +
            "}";
    }




}