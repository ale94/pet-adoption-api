package ar.com.ale94.pet_adoption_api.models.requests;

import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Long customerId;
    @NotNull
    private Long petId;
}
