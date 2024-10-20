package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.dtos.CustomerDTO;
import ar.com.ale94.pet_adoption_api.entities.CustomerEntity;

public interface ICustomerService extends ICrudService<CustomerDTO, CustomerEntity, Long> {
}
