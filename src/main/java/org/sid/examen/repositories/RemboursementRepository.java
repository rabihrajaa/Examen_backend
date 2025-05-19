package org.sid.examen.repositories;

import org.sid.examen.entities.Remboursement;
import org.sid.examen.enums.TypeRemboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
    List<Remboursement> findByCreditId(Long creditId);
    List<Remboursement> findByType(TypeRemboursement type);
}
