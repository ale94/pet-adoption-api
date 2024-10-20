package ar.com.ale94.pet_adoption_api.repositories;

import ar.com.ale94.pet_adoption_api.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByName(String name);
}
