package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.dtos.UserDTO;
import ar.com.ale94.pet_adoption_api.entities.UserEntity;
import ar.com.ale94.pet_adoption_api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public List<UserEntity> read() {
        return this.userRepository.findAll();
    }

    @Override
    public UserEntity readById(Long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    @Override
    public UserEntity save(UserDTO request) {
        var userToPersit = UserEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .registrationDate(LocalDateTime.now())
                .build();
        var userPersisted = this.userRepository.save(userToPersit);
        log.info("User saved with id {}", userPersisted.getId());
        return userPersisted;
    }

    @Override
    public UserEntity update(UserDTO request, Long id) {
        var userToUpdate = this.userRepository.findById(id).orElseThrow();
        userToUpdate.setName(request.getName());
        userToUpdate.setEmail(request.getEmail());
        userToUpdate.setPhone(request.getPhone());
        userToUpdate.setAddress(request.getAddress());
        var userUpdated = this.userRepository.save(userToUpdate);
        log.info("User updated with id {}", userUpdated.getId());
        return userUpdated;
    }

    @Override
    public void delete(Long id) {
        var userToDelete = this.userRepository.findById(id).orElseThrow();
        this.userRepository.delete(userToDelete);
    }
}
