package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.dtos.CustomerDTO;
import ar.com.ale94.pet_adoption_api.entities.CustomerEntity;
import ar.com.ale94.pet_adoption_api.repositories.CustomerRepository;
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
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> read() {
        return this.customerRepository.findAll();
    }

    @Override
    public CustomerEntity readById(Long id) {
        return this.customerRepository.findById(id).orElseThrow();
    }

    @Override
    public CustomerEntity save(CustomerDTO request) {
        var userToPersit = CustomerEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .registrationDate(LocalDateTime.now())
                .build();
        var userPersisted = this.customerRepository.save(userToPersit);
        log.info("Customer saved with id {}", userPersisted.getId());
        return userPersisted;
    }

    @Override
    public CustomerEntity update(CustomerDTO request, Long id) {
        var userToUpdate = this.customerRepository.findById(id).orElseThrow();
        userToUpdate.setName(request.getName());
        userToUpdate.setEmail(request.getEmail());
        userToUpdate.setPhone(request.getPhone());
        userToUpdate.setAddress(request.getAddress());
        var userUpdated = this.customerRepository.save(userToUpdate);
        log.info("Customer updated with id {}", userUpdated.getId());
        return userUpdated;
    }

    @Override
    public void delete(Long id) {
        var userToDelete = this.customerRepository.findById(id).orElseThrow();
        this.customerRepository.delete(userToDelete);
    }
}
