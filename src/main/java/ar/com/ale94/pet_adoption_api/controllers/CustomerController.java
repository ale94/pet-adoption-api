package ar.com.ale94.pet_adoption_api.controllers;

import ar.com.ale94.pet_adoption_api.models.requests.CustomerRequest;
import ar.com.ale94.pet_adoption_api.models.responses.CustomerResponse;
import ar.com.ale94.pet_adoption_api.services.ICustomerService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<CustomerResponse>> getAll() {
        return ResponseEntity.ok(this.customerService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.readById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.customerService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@Valid @RequestBody CustomerRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.update(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerResponse> delete(@PathVariable Long id) {
        this.customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
