package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.dtos.PetDTO;
import ar.com.ale94.pet_adoption_api.entities.PetEntity;
import ar.com.ale94.pet_adoption_api.repositories.PetRepository;
import ar.com.ale94.pet_adoption_api.repositories.PetTypeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public List<PetEntity> read() {
        return this.petRepository.findAll();
    }

    @Override
    public PetEntity readById(Long id) {
        return this.petRepository.findById(id).orElseThrow();
    }

    @Override
    public PetEntity save(PetDTO request) {

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
        return petPersisted;
    }

    @Override
    public PetEntity update(PetDTO request, Long id) {
        var petToUpdate = this.petRepository.findById(id).orElseThrow();
        petToUpdate.setName(request.getName());
        petToUpdate.setAge(request.getAge());
        petToUpdate.setBreed(request.getBreed());
        petToUpdate.setDescription(request.getDescription());
        petToUpdate.setImageUrl(request.getImageUrl());
        petToUpdate.setGender(request.getGender());
        var petPersisted = this.petRepository.save(petToUpdate);
        log.info("Pet updated with id {}", petPersisted.getId());
        return petPersisted;
    }

    @Override
    public void delete(Long id) {
        var petToDelete = this.petRepository.findById(id).orElseThrow();
        this.petRepository.delete(petToDelete);
    }
}
