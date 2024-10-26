package ar.com.ale94.pet_adoption_api.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorsResponse implements Serializable {
    private String status;
    private Integer code;
    private List<String> errors;
}
