package ar.com.ale94.pet_adoption_api.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetRequest implements Serializable {

    @NotBlank
    private String name;
    @NotBlank
    private Integer age;
    @NotBlank
    private String breed;
    private String description;
    private String imageUrl;
    private String gender;
    private String petType;
}
