package org.sid.examen.web;

import org.sid.examen.dtos.ClientDTO;
import org.sid.examen.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO dto) {
        return clientService.save(dto);
    }
}
