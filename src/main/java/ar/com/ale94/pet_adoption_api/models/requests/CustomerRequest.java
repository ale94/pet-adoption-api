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
public class CustomerRequest implements Serializable {

    private String name;
    private String email;
    private String phone;
    private String address;

}
