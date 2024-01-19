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
    private List<Usuario> createdUsers;
    private List<Response> responses;
    Response useResponse;
    String expectedContentType = "application/json";


    @Dado("que envio dados para a criacao do usuario")
    public void que_envio_dados_para_a_criacao_do_usuario(DataTable dataTable) {
        List<Map<String, String>> usuariosData = dataTable.asMaps(String.class, String.class);

        createdUsers = new ArrayList<>();
        responses = new ArrayList<>();

        for (Map<String, String> userData : usuariosData) {
            expectedUser = new Usuario();
            expectedUser.setUsername(userData.get("username"));
            expectedUser.setPassword(userData.get("password"));
            expectedUser.setFirstName(userData.get("firstName"));
            expectedUser.setLastName(userData.get("lastName"));
            expectedUser.setEmail(userData.get("email"));
            expectedUser.setPhone(userData.get("phone"));
            expectedUser.setUserStatus(Integer.parseInt(userData.get("userStatus")));
            createdUsers.add(expectedUser);
            System.out.println("Estes são os usuários para serem criados: " + createdUsers);
        }
    }

    @Quando("preformo a criacao dos usuarios")
    public void preformo_a_criacao_dos_usuarios() {
        responses = new ArrayList<>(); // Certifique-se de inicializar a lista de respostas

        for (Usuario user : createdUsers) {
            Response response = usuarioApi.createUser(user);
            responses.add(response);
        }

        // Como você quer validar os dados, podemos usar a última resposta na lista para simplificar
        useResponse = responses.get(responses.size() - 1);
    }


    @Entao("valido os dados dos usuarios criados")
    public void valido_os_dados_dos_usuarios_criados() {
        for (Usuario createdUser : createdUsers) {


            assertThat("Valida Content-Type", useResponse.contentType(), equalTo(expectedContentType));
            assertThat("Valida HTTP Status", useResponse.statusCode(), equalTo(HttpStatus.SC_OK));
            assertThat("Valida Username", useResponse.path("username"), equalTo(createdUser.getUsername()));
            assertThat("Valida password", useResponse.path("password"), equalTo(createdUser.getPassword()));
            assertThat("Valida firstName", useResponse.path("firstName"), equalTo(createdUser.getFirstName()));
            assertThat("Valida lastName", useResponse.path("lastName"), equalTo(createdUser.getLastName()));
            assertThat("Valida email", useResponse.path("email"), equalTo(createdUser.getEmail()));
            assertThat("Valida phone", useResponse.path("phone"), equalTo(createdUser.getPhone()));
            assertThat("Valida UserStatus", useResponse.path("userStatus"), equalTo(createdUser.getUserStatus()));

        }
    }

}
