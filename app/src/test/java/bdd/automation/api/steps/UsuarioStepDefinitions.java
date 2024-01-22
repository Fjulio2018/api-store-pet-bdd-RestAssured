package bdd.automation.api.steps;

import bdd.automation.api.support.api.UsuarioApi;
import bdd.automation.api.support.dominio.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsuarioStepDefinitions {

    private final UsuarioApi usuarioApi = new UsuarioApi();
    private Usuario expectedUser;
    private List<Usuario> createrUsers;
    private List<Response> responses;
    Response useResponse;
    String expectedContentType = "application/json";

    String MSG_ERROR ;




    @Dado("que envio dados para a criacao do usuario")
    public void que_envio_dados_para_a_criacao_do_usuario(DataTable dataTable) {
        List<Map<String, String>> usuariosData = dataTable.asMaps(String.class, String.class);

        createrUsers = new ArrayList<>();
        responses = new ArrayList<>();


        for (Map<String, String> userData : usuariosData) {


            MSG_ERROR = userData.get("MSG");
            expectedUser = new Usuario();

            String id = userData.get("id");
            if(!(id == null)) {
                expectedUser.setId(userData.get("id"));
            }else {
                expectedUser.setId(" ");
            };

            expectedUser.setUsername(userData.get("username"));
            expectedUser.setPassword(userData.get("password"));
            expectedUser.setFirstName(userData.get("firstName"));
            expectedUser.setLastName(userData.get("lastName"));
            expectedUser.setEmail(userData.get("email"));
            expectedUser.setPhone(userData.get("phone"));


            String userStatus = userData.get("userStatus");
                    if(!(userStatus == null)) {
                        expectedUser.setUserStatus(userStatus);
                    }else {
                        expectedUser.setUserStatus(" ");
                    };


            createrUsers.add(expectedUser);
            System.out.println("Estes sao o dado do Step / createrUsers: " + createrUsers);
        }
    }


    @Quando("preformo a criacao dos usuarios")
    public void preformo_a_criacao_dos_usuarios() {
        responses = new ArrayList<>();

        for (Usuario user : createrUsers) {
            Response response = usuarioApi.createUser(user);
            responses.add(response);
        }

        useResponse = responses.get(responses.size() - 1);
    }


    @Entao("valido os dados dos usuarios criados")
    public void valido_os_dados_dos_usuarios_criados() {
        for (Usuario createrUser : createrUsers) {


            assertThat("Valida Content-Type", useResponse.contentType(), equalTo(expectedContentType));
            assertThat("Valida HTTP Status", useResponse.statusCode(), equalTo(HttpStatus.SC_OK));
            assertThat("Valida ID", useResponse.path("id"),equalTo(Integer.valueOf(createrUser.getId())));
            assertThat("Valida Username", useResponse.path("username"), equalTo(createrUser.getUsername()));
            assertThat("Valida password", useResponse.path("password"), equalTo(createrUser.getPassword()));
            assertThat("Valida firstName", useResponse.path("firstName"), equalTo(createrUser.getFirstName()));
            assertThat("Valida lastName", useResponse.path("lastName"), equalTo(createrUser.getLastName()));
            assertThat("Valida email", useResponse.path("email"), equalTo(createrUser.getEmail()));
            assertThat("Valida phone", useResponse.path("phone"), equalTo(createrUser.getPhone()));
            assertThat("Valida UserStatus", useResponse.path("userStatus"), equalTo(Integer.valueOf(createrUser.getUserStatus())));

        }
    }

    @Entao("valido retornos e mensagens de erro")
    public void valido_retornos_e_mensagens_de_erro() {


        assertThat("Valida HTTP Status", useResponse.statusCode(), equalTo(HttpStatus.SC_BAD_REQUEST));

        assertThat("Valida UserStatus", useResponse.path("message"), equalTo(MSG_ERROR.toString()));

    }


}
