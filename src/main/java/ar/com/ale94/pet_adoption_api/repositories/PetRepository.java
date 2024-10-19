package ar.com.ale94.pet_adoption_api.repositories;

import ar.com.ale94.pet_adoption_api.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<PetEntity, Long> {

    Optional<PetEntity> findByName(String name);
}
