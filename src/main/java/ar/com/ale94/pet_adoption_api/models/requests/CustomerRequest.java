package ar.com.ale94.pet_adoption_api.models.requests;

import jakarta.validation.constraints.Email;
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
public class CustomerRequest implements Serializable {

    @NotBlank
    @Size(min = 4, max = 15)
    private String name;
    @NotBlank
    @Email
    private String email;
    private String phone;
    private String address;

}
