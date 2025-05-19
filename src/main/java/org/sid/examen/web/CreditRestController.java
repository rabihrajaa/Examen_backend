package org.sid.examen.web;

import org.sid.examen.dtos.*;
import org.sid.examen.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/credits")
public class CreditRestController {

    @Autowired
    private CreditService creditService;

    @GetMapping
    public List<CreditDTO> getAllCredits() {
        return creditService.getAllCredits();
    }

    @PostMapping("/personnel")
    public CreditDTO savePersonnel(@RequestBody CreditPersonnelDTO dto) {
        return creditService.savePersonnel(dto);
    }

    @PostMapping("/immobilier")
    public CreditDTO saveImmobilier(@RequestBody CreditImmobilierDTO dto) {
        return creditService.saveImmobilier(dto);
    }

    @PostMapping("/professionnel")
    public CreditDTO saveProfessionnel(@RequestBody CreditProfessionnelDTO dto) {
        return creditService.saveProfessionnel(dto);
    }
}
