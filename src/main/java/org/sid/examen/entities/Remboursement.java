package org.sid.examen.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.examen.entities.Credit;
import org.sid.examen.enums.TypeRemboursement;

import java.util.Date;
@Data @AllArgsConstructor
@NoArgsConstructor
@Entity
public class Remboursement {
    @Id
    @GeneratedValue
    private Long id;

    private Date date;
    private Double montant;
    private TypeRemboursement type;

    @ManyToOne
    private Credit credit;
}
