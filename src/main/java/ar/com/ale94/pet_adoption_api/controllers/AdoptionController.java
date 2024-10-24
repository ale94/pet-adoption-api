package ar.com.ale94.pet_adoption_api.controllers;

import ar.com.ale94.pet_adoption_api.models.requests.AdoptionRequest;
import ar.com.ale94.pet_adoption_api.models.responses.AdoptionResponse;
import ar.com.ale94.pet_adoption_api.services.AdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adoptions")
@RequiredArgsConstructor
public class AdoptionController {

    private final AdoptionService adoptionService;

    @PostMapping
    public ResponseEntity<AdoptionResponse> create(@RequestBody AdoptionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adoptionService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<AdoptionResponse>> getAll() {
        return ResponseEntity.ok(adoptionService.getAll());
    }
}
