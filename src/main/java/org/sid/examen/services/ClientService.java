package org.sid.examen.services;

import org.sid.examen.dtos.ClientDTO;
import org.sid.examen.entities.Client;
import org.sid.examen.mappers.GlobalMapper;
import org.sid.examen.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(GlobalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO save(ClientDTO dto) {
        Client client = GlobalMapper.toEntity(dto);
        client = clientRepository.save(client);
        return GlobalMapper.toDTO(client);
    }

    public Client getClientEntityById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
