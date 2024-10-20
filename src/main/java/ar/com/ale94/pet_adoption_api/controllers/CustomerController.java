package ar.com.ale94.pet_adoption_api.controllers;

import ar.com.ale94.pet_adoption_api.dtos.CustomerDTO;
import ar.com.ale94.pet_adoption_api.entities.CustomerEntity;
import ar.com.ale94.pet_adoption_api.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAll() {
        return ResponseEntity.ok(this.customerService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.readById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> create(@RequestBody CustomerDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.customerService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerEntity> update(@RequestBody CustomerDTO request, @PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.update(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerEntity> delete(@PathVariable Long id) {
        this.customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
