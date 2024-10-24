package ar.com.ale94.pet_adoption_api.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdoptionRequest implements Serializable {
    private Long customerId;
    private Long petId;
}
