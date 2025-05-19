package org.sid.examen.web;

import org.sid.examen.dtos.RemboursementDTO;
import org.sid.examen.services.RemboursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remboursements")
public class RemboursementRestController {

    @Autowired
    private RemboursementService remboursementService;

    @GetMapping
    public List<RemboursementDTO> getAll() {
        return remboursementService.getAll();
    }

    @PostMapping
    public RemboursementDTO save(@RequestBody RemboursementDTO dto) {
        return remboursementService.save(dto);
    }
}
