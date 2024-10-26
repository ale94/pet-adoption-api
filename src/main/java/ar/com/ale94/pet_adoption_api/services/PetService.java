package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.entities.PetEntity;
import ar.com.ale94.pet_adoption_api.enums.Tables;
import ar.com.ale94.pet_adoption_api.exceptions.IdNotFoundException;
import ar.com.ale94.pet_adoption_api.models.requests.PetRequest;
import ar.com.ale94.pet_adoption_api.models.responses.PetResponse;
import ar.com.ale94.pet_adoption_api.repositories.PetRepository;
import ar.com.ale94.pet_adoption_api.repositories.PetTypeRepository;
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
public class PetService implements IPetService {

    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    @Override
    public List<PetResponse> read() {
        return this.petRepository.findAll()
                .stream()
                .map(this::entityToResponse)
                .toList();
    }

    @Override
    public PetResponse readById(Long id) {
        return this.entityToResponse(this.petRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(Tables.pet.name())));
    }

    @Override
    public PetResponse save(PetRequest request) {

        long petType = 0L;
        switch (request.getPetType().toLowerCase()) {
            case "perro" -> petType = 1L;
            case "gato" -> petType = 2L;
        }
        var petToPersit = PetEntity.builder()
                .name(request.getName())
                .age(request.getAge())
                .available(true)
                .breed(request.getBreed())
                .description(request.getDescription())
                .entryDate(LocalDateTime.now())
                .imageUrl(request.getImageUrl())
                .gender(request.getGender())
                .petType(this.petTypeRepository.findById(petType).orElseThrow())
                .build();
        var petPersisted = this.petRepository.save(petToPersit);
        log.info("Pet saved with id {}", petPersisted.getId());
        return this.entityToResponse(petPersisted);
    }

    @Override
    public PetResponse update(PetRequest request, Long id) {
        var petToUpdate = this.petRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(Tables.pet.name()));
        petToUpdate.setName(request.getName());
        petToUpdate.setAge(request.getAge());
        petToUpdate.setBreed(request.getBreed());
        petToUpdate.setDescription(request.getDescription());
        petToUpdate.setImageUrl(request.getImageUrl());
        petToUpdate.setGender(request.getGender());
        var petPersisted = this.petRepository.save(petToUpdate);
        log.info("Pet updated with id {}", petPersisted.getId());
        return this.entityToResponse(petPersisted);
    }

    @Override
    public void delete(Long id) {
        var petToDelete = this.petRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(Tables.pet.name()));
        this.petRepository.delete(petToDelete);
    }

    private PetResponse entityToResponse(PetEntity entity) {
        var response = new PetResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
