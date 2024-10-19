package ar.com.ale94.pet_adoption_api.services;

import ar.com.ale94.pet_adoption_api.dtos.UserDTO;
import ar.com.ale94.pet_adoption_api.entities.UserEntity;

public interface IUserService extends ICrudService<UserDTO, UserEntity, Long> {
}
