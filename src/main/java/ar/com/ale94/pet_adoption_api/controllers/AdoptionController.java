package ar.com.ale94.pet_adoption_api.controllers;

import ar.com.ale94.pet_adoption_api.dtos.AdoptionDTO;
import ar.com.ale94.pet_adoption_api.entities.AdoptionEntity;
import ar.com.ale94.pet_adoption_api.services.AdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adoptions")
@RequiredArgsConstructor
public class AdoptionController {

    private final AdoptionService adoptionService;

    @PostMapping
    public ResponseEntity<AdoptionEntity> create(@RequestBody AdoptionDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adoptionService.save(request));
    }
}
