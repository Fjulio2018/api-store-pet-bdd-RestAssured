package bdd.automation.api.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import bdd.automation.api.support.api.UserApi;

public class Config {


    private UserApi userApi = new UserApi();

    @Before
    public void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = "http://localhost:12345";
        RestAssured.basePath = "/api";

        RequestSpecification requestSpec = new RequestSpecBuilder()
                .addHeader("Authorization", getToken())
                .setContentType(ContentType.JSON)
                .build();



        RestAssured.requestSpecification = requestSpec;

    }

    private String getToken() {
        return "grant_access";
    }

    @After("@deleteUser")
    public void deleteUser() {

        userApi.deleteUser();

    }
}



