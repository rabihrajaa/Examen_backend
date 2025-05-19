package org.sid.examen.services;

import org.sid.examen.dtos.RemboursementDTO;
import org.sid.examen.entities.Credit;
import org.sid.examen.entities.Remboursement;
import org.sid.examen.mappers.GlobalMapper;
import org.sid.examen.repositories.RemboursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemboursementService {

    @Autowired
    private RemboursementRepository remboursementRepository;

    @Autowired
    private CreditService creditService;

    public List<RemboursementDTO> getAll() {
        return remboursementRepository.findAll().stream()
                .map(GlobalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RemboursementDTO save(RemboursementDTO dto) {
        Credit credit = creditService.getCreditEntityById(dto.getCreditId());
        Remboursement remboursement = GlobalMapper.toEntity(dto, credit);
        return GlobalMapper.toDTO(remboursementRepository.save(remboursement));
    }
}
