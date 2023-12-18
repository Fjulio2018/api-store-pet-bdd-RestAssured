package support.api;

import org.apache.http.HttpStatus;
import org.hamcrest.core.Is;
import steps.UserStepDefinitions;
import support.dominio.User;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class UserApi {


    private static final String CREATED_USER_ENDPOINT = "/v3/user/";
    private static final String USER_ENDPOINT = "/v3/user/{name}";


    public UserApi() {
    }

    public void createUser(User user) {

        given().
                body(user).
        when().
                post(CREATED_USER_ENDPOINT).
         then().
                statusCode(HttpStatus.SC_OK);


    }


    public String getUsername(User user) {
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
