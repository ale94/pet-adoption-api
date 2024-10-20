package ar.com.ale94.pet_adoption_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdoptionDTO implements Serializable {
    private Long userId;
    private Long petId;
}
