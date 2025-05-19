package org.sid.examen.repositories;

import org.sid.examen.entities.CreditImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
    List<CreditImmobilier> findByTypeBien(String typeBien);
}

