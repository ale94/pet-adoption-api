package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.models.requests.CustomerRequest;
import ar.com.ale94.pet_adoption_api.models.responses.CustomerResponse;

public interface ICustomerService extends ICrudService<CustomerRequest, CustomerResponse, Long> {
}
