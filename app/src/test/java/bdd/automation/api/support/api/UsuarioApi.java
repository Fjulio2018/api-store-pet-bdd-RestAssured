package bdd.automation.api.support.api;

import bdd.automation.api.support.dominio.Usuario;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UsuarioApi {


    private static final String CREATED_USER_ENDPOINT = "/v3/user/";
    private static final String USER_ENDPOINT = "/v3/user/{name}";


    public UsuarioApi() {
    }

    public Response createUser(Usuario user) {

        System.out.println("Estes dados sao do envio API: " + user.toString());
        Response response = given()
                .body(user)
                .log().all()
                .when()
                .post(CREATED_USER_ENDPOINT)
                .then()
                .log().all()
                .extract()
                .response()

                ;

        return response;
    }



    public Response getUsername(Usuario user) {
        return given().
                pathParam("name", user.getUsername()).
                when().
                get(USER_ENDPOINT).
                thenReturn().
                path("username");

    }

    public void deleteUser() {
        List<String> userList = Arrays.asList("Nick");

        for ( String userL : userList) {

            given().
                    pathParam("name", userL).
                    when().
                    delete(USER_ENDPOINT).
                    then().
                    statusCode(HttpStatus.SC_OK);

        }


    }
}
