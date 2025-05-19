package org.sid.examen.repositories;
import org.sid.examen.entities.Credit;
import org.sid.examen.enums.StatutCredit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    List<Credit> findByClientId(Long clientId);
    List<Credit> findByStatut(StatutCredit statut);
}

