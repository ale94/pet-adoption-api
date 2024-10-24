package ar.com.ale94.pet_adoption_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Pet Adoption API",
                version = "1.0",
                description = "Documentation for endpoints in Pet Adoption"
        )
)
public class OpenApiConfig {
}
