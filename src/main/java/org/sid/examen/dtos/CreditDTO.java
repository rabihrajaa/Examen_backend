package org.sid.examen.dtos;

import lombok.Data;

@Data
public class CreditDTO {
    private Long id;
    private String type;
    private String dateDemande;
    private String statut;
    private String dateAcception;
    private Double montant;
    private int duree;
    private Double tauxInteret;
    private Long clientId;
}

