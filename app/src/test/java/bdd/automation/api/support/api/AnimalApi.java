package bdd.automation.api.support.api;

import static io.restassured.RestAssured.*;

import bdd.automation.api.support.dominio.Animal;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class AnimalApi {

    private static final String FIND_PETS_BY_STATUS_ENDPOINT = "/v3/pet/findByStatus?status={status}";


    public Response getPetByResponse(String status) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.pathParam("status", status);

          Response response = httpRequest.get( FIND_PETS_BY_STATUS_ENDPOINT);


        return response;
    }


    public List<Animal> getPetByList(String status) {

        return given()
                .pathParam("status", status)
                .when()
                .get(FIND_PETS_BY_STATUS_ENDPOINT)
                .then()
                .extract().body().jsonPath().getList("", Animal.class);
    }




}
