package org.sid.examen.repositories;

import org.sid.examen.entities.CreditProfessionnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditProfessionnelRepository extends JpaRepository<CreditProfessionnel, Long> {
    List<CreditProfessionnel> findByRaisonSocialeContainingIgnoreCase(String raisonSociale);
}

