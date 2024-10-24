package ar.com.ale94.pet_adoption_api.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdoptionResponse implements Serializable {
    private Long id;
    private LocalDateTime adoptionDate;
    private String customer;
    private String pet;
}
