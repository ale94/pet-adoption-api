package ar.com.ale94.pet_adoption_api.controllers;

import ar.com.ale94.pet_adoption_api.models.requests.AdoptionRequest;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdoptionControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void testListAll() {
        var response = restTemplate.getForEntity("/api/adoptions", String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // COMPROBAR SI EXISTE 2 ADOPCIONES
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Integer adoptionCount = documentContext.read("$.length()");
        Assertions.assertThat(adoptionCount).isEqualTo(2);

        // COMPROBAR QUE EXISTEN 2 USUARIOS ASOCIADO
        JSONArray customers = documentContext.read("$..customer_id");
        Assertions.assertThat(customers).containsExactlyInAnyOrder(1, 4);

        // COMPROBAR QUE EXISTE 2 MASCOTA ASOCIADO
        JSONArray pets = documentContext.read("$..pet_id");
        Assertions.assertThat(pets).containsExactlyInAnyOrder(2, 4);

    }

    @Test
    @DirtiesContext
    void testNewAdoption() {
        AdoptionRequest request = AdoptionRequest.builder()
                .customerId(1L)
                .petId(2L)
                .build();
        ResponseEntity<Void> response = restTemplate.postForEntity("/api/adoptions", request, Void.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        URI location = response.getHeaders().getLocation();
        ResponseEntity<String> getResponse = restTemplate.getForEntity(location, String.class);
        Assertions.assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
