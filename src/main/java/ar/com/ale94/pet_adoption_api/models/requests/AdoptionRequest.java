package ar.com.ale94.pet_adoption_api.models.requests;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private Long customerId;
    @NotBlank
    private Long petId;
}
