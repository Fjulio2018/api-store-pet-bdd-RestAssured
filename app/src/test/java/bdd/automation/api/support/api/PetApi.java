package bdd.automation.api.support.api;

import static io.restassured.RestAssured.*;

import bdd.automation.api.support.dominio.Pet;

import java.util.List;

public class PetApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus?status={status}";


    public List<Pet> getPetByStatus(String status) {
        String response = given()
                .pathParam("status", status)
                .when()
                .get(FIND_PETS_BY_STATUS_ENDPOINT)
                .then()
                .extract().body().asString();

        System.out.println("API Response: " + response);

        return given()
                .pathParam("status", status)
                .when()
                .get(FIND_PETS_BY_STATUS_ENDPOINT)
                .then()
                .extract().body().jsonPath().getList("", Pet.class);
    }

}
