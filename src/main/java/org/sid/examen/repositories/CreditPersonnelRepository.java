package org.sid.examen.repositories;

import org.sid.examen.entities.CreditPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel, Long> {
    List<CreditPersonnel> findByMotifContainingIgnoreCase(String motif);
}
