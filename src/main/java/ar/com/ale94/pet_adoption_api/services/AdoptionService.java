package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.dtos.AdoptionDTO;
import ar.com.ale94.pet_adoption_api.entities.AdoptionEntity;
import ar.com.ale94.pet_adoption_api.repositories.AdoptionRepository;
import ar.com.ale94.pet_adoption_api.repositories.CustomerRepository;
import ar.com.ale94.pet_adoption_api.repositories.PetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AdoptionService {

    private final AdoptionRepository adoptionRepository;
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    public AdoptionEntity save(AdoptionDTO request) {
        var customer = this.customerRepository.findById(request.getCustomerId()).orElseThrow();
        var pet = this.petRepository.findById(request.getPetId()).orElseThrow();
        var adoptionToPersist = AdoptionEntity.builder()
                .customer(customer)
                .pet(pet)
                .adoptionDate(LocalDateTime.now())
                .build();
        var adoptionPersisted = this.adoptionRepository.save(adoptionToPersist);
        log.info("Adoption saved with id {}", adoptionPersisted.getId());
        return adoptionPersisted;
    }
}
