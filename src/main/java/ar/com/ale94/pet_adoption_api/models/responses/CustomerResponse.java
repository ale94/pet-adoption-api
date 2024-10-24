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
public class CustomerResponse implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime registrationDate;
}
