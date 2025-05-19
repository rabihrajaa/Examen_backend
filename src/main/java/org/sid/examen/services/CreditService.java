package org.sid.examen.services;

import org.sid.examen.dtos.*;
import org.sid.examen.entities.*;
import org.sid.examen.mappers.GlobalMapper;
import org.sid.examen.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private ClientService clientService;

    public List<CreditDTO> getAllCredits() {
        return creditRepository.findAll().stream()
                .map(GlobalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CreditDTO savePersonnel(CreditPersonnelDTO dto) {
        Client client = clientService.getClientEntityById(dto.getClientId());
        CreditPersonnel credit = GlobalMapper.toEntity(dto, client);
        return GlobalMapper.toDTO(creditRepository.save(credit));
    }

    public CreditDTO saveImmobilier(CreditImmobilierDTO dto) {
        Client client = clientService.getClientEntityById(dto.getClientId());
        CreditImmobilier credit = GlobalMapper.toEntity(dto, client);
        return GlobalMapper.toDTO(creditRepository.save(credit));
    }

    public CreditDTO saveProfessionnel(CreditProfessionnelDTO dto) {
        Client client = clientService.getClientEntityById(dto.getClientId());
        CreditProfessionnel credit = GlobalMapper.toEntity(dto, client);
        return GlobalMapper.toDTO(creditRepository.save(credit));
    }

    public Credit getCreditEntityById(Long id) {
        return creditRepository.findById(id).orElse(null);
    }
}
