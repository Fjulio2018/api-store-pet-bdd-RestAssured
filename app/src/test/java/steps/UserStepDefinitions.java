package steps;

import io.cucumber.java.pt.Entao;
import support.api.UserApi;
import support.dominio.User;
import io.cucumber.java.it.Quando;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class UserStepDefinitions {




    private User expectedUser = User.builder().build();
    private UserApi userApi = new UserApi();





    @Quando("criar um usuario")
    public void criar_um_usuario() {


        userApi.createUser(expectedUser);


    }


    @Entao("valido usuario criado")
    public void valido_usuario_criado() {

        String usercreated = userApi.getUsername(expectedUser);
        assertThat(usercreated,is(expectedUser.getUsername()));

    }


}
