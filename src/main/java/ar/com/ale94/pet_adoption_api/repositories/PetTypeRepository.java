package ar.com.ale94.pet_adoption_api.repositories;

import ar.com.ale94.pet_adoption_api.entities.PetTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetTypeEntity, Long> {
}
