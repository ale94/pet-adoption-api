package ar.com.ale94.pet_adoption_api.controllers;

import ar.com.ale94.pet_adoption_api.dtos.PetDTO;
import ar.com.ale94.pet_adoption_api.entities.PetEntity;
import ar.com.ale94.pet_adoption_api.services.IPetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {

    private final IPetService petService;

    @GetMapping
    public ResponseEntity<List<PetEntity>> getAll() {
        return ResponseEntity.ok(this.petService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.petService.readById(id));
    }

    @PostMapping
    public ResponseEntity<PetEntity> create(@RequestBody PetDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.petService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetEntity> update(@RequestBody PetDTO request, @PathVariable Long id) {
        return ResponseEntity.ok(this.petService.update(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PetEntity> delete(@PathVariable Long id) {
        this.petService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
