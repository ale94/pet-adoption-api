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
public class PetResponse implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private Boolean available;
    private String breed;
    private String description;
    private LocalDateTime entryDate;
    private String imageUrl;
    private String gender;
}
