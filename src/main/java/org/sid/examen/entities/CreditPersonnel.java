package org.sid.examen.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditPersonnel extends Credit {
    private String motif;
}

