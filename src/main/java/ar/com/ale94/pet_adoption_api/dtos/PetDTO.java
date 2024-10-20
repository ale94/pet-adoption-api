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
public class PetDTO implements Serializable {

    private String name;
    private Integer age;
    private String breed;
    private String description;
    private String imageUrl;
    private String gender;
    private String petType;
}
