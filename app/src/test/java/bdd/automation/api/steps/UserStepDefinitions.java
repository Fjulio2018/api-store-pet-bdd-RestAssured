package bdd.automation.api.steps;

import io.cucumber.java.pt.Entao;
import bdd.automation.api.support.api.UserApi;
import bdd.automation.api.support.dominio.User;
import io.cucumber.java.it.Quando;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class UserStepDefinitions {




    private final User expectedUser = User.builder().build();
    private final UserApi userApi = new UserApi();





    @Quando("criar um usuario")
    public void criar_um_usuario() {

        userApi.createUser(expectedUser);
    }


    @Entao("valido usuario criado")
    public void valido_usuario_criado() {

        String userCreated = userApi.getUsername(expectedUser);

        assertThat(userCreated,is(expectedUser.getUsername()));

    }


}
