package org.sid.examen.dtos;

import lombok.Data;

@Data
public class RemboursementDTO {
    private Long id;
    private String date;
    private Double montant;
    private String type; // "Mensualité", "Remboursement anticipé"
    private Long creditId;
}
