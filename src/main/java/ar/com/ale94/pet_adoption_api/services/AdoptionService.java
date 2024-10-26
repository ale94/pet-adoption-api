package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.entities.AdoptionEntity;
import ar.com.ale94.pet_adoption_api.enums.Tables;
import ar.com.ale94.pet_adoption_api.exceptions.IdNotFoundException;
import ar.com.ale94.pet_adoption_api.models.requests.AdoptionRequest;
import ar.com.ale94.pet_adoption_api.models.responses.AdoptionResponse;
import ar.com.ale94.pet_adoption_api.repositories.AdoptionRepository;
import ar.com.ale94.pet_adoption_api.repositories.CustomerRepository;
import ar.com.ale94.pet_adoption_api.repositories.PetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AdoptionService {

    private final AdoptionRepository adoptionRepository;
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    public AdoptionResponse save(AdoptionRequest request) {
        var customer = this.customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IdNotFoundException(Tables.customer.name()));
        var pet = this.petRepository.findById(request.getPetId())
                .orElseThrow(() -> new IdNotFoundException(Tables.pet.name()));
        var adoptionToPersist = AdoptionEntity.builder()
                .customer(customer)
                .pet(pet)
                .adoptionDate(LocalDateTime.now())
                .build();
        var adoptionPersisted = this.adoptionRepository.save(adoptionToPersist);
        log.info("Adoption saved with id {}", adoptionPersisted.getId());
        return this.entityToResponse(adoptionPersisted);
    }

    public List<AdoptionResponse> getAll() {
        return this.adoptionRepository.findAll().stream()
                .map(this::entityToResponse)
                .toList();
    }

    private AdoptionResponse entityToResponse(AdoptionEntity entity) {
        var response = new AdoptionResponse();
        BeanUtils.copyProperties(entity, response);
        response.setPet(entity.getPet().getName());
        response.setCustomer(entity.getCustomer().getName());
        return response;
    }
}
