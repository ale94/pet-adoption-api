package ar.com.ale94.pet_adoption_api.repositories;

import ar.com.ale94.pet_adoption_api.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByName(String name);
}
