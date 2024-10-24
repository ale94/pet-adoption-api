package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.models.requests.PetRequest;
import ar.com.ale94.pet_adoption_api.models.responses.PetResponse;

public interface IPetService extends ICrudService<PetRequest, PetResponse, Long> {
}
