package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.dtos.PetDTO;
import ar.com.ale94.pet_adoption_api.entities.PetEntity;

public interface IPetService extends ICrudService<PetDTO, PetEntity, Long> {
}
