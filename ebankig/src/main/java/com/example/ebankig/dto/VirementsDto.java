package com.example.ebankig.dto;


public class VirementsDto {

    
    private Long id; 

    private String motif;

    private Double montant;




    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotif() {
        return this.motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Double getMontant() {
        return this.montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }




    public VirementsDto() {
    }

    public VirementsDto(Long id, String motif, Double montant) {
        this.id = id;
        this.motif = motif;
        this.montant = montant;
    }
   


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", motif='" + getMotif() + "'" +
            ", montant='" + getMontant() + "'" +
            "}";
    }

}