package com.example.B2Bproject.controller;

import com.example.B2Bproject.dto.EntrepriseDTO;
import com.example.B2Bproject.service.EntrepriseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/entreprises")


public class EntrepriseController {


    private final EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @PostMapping
    public ResponseEntity<EntrepriseDTO> createEntreprise(@RequestBody EntrepriseDTO entrepriseDTO) {
        EntrepriseDTO createdEntreprise = entrepriseService.createEntreprise(entrepriseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntreprise);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrepriseDTO> getEntrepriseById(@PathVariable Long id) {
        EntrepriseDTO entrepriseDTO = entrepriseService.getEntrepriseById(id);
        return ResponseEntity.ok(entrepriseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EntrepriseDTO>> getAllEntreprises() {
        List<EntrepriseDTO> entrepriseDTOs = entrepriseService.getAllEntreprises();
        return ResponseEntity.ok(entrepriseDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrepriseDTO> updateEntreprise(@PathVariable Long id, @RequestBody EntrepriseDTO entrepriseDTO) {
        EntrepriseDTO updatedEntreprise = entrepriseService.updateEntreprise(id, entrepriseDTO);
        return ResponseEntity.ok(updatedEntreprise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntreprise(@PathVariable Long id) {
        entrepriseService.deleteEntreprise(id);
        return ResponseEntity.noContent().build();
    }
}
