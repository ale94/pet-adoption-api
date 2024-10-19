package ar.com.ale94.pet_adoption_api.repositories;

import ar.com.ale94.pet_adoption_api.entities.AdoptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<AdoptionEntity, Long> {
}
