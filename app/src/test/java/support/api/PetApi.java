package support.api;

import io.restassured.response.ResponseBody;
import static io.restassured.RestAssured.*;

import support.dominio.Pet;

import java.util.List;

public class PetApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus";

    public List<Pet> getPetByStatus(String status) {
        return given()
                .pathParam("status", status)
                .when()
                .get(FIND_PETS_BY_STATUS_ENDPOINT)
                .then()
                .extract().body().jsonPath().getList("", Pet.class);
    }
}
