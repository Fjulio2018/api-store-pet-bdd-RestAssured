package bdd.automation.api.steps;

import io.cucumber.java.pt.Entao;
import bdd.automation.api.support.api.UsuarioApi;
import bdd.automation.api.support.dominio.Usuario;
import io.cucumber.java.it.Quando;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class UsuarioStepDefinitions {




    private final Usuario expectedUser = Usuario.builder().build();
    private final UsuarioApi userApi = new UsuarioApi();





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
