package bdd.automation.api.steps;

import bdd.automation.api.support.mapper.UsuarioMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Data;
import io.cucumber.java.pt.Entao;
import bdd.automation.api.support.api.UsuarioApi;
import bdd.automation.api.support.dominio.Usuario;
import io.cucumber.java.it.Quando;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class UsuarioStepDefinitions {




    private final Usuario expectedUser = Usuario.builder().build();
    private final UsuarioApi usuarioApi = new UsuarioApi();

    private Response response;





    @Quando("criar um usuario")
    public void criar_um_usuario() {
        usuarioApi.createUser(expectedUser);
    }

    @Dado("envio dados para a criacao do usuario")
    public void que_envio_dados_para_a_criacao_do_usuario(List<Map<String, String>> usuariosData) {

        for (Map<String, String> userData : usuariosData) {
            expectedUser.setUsername(userData.get("username"));
            expectedUser.setPassword(userData.get("password"));
            expectedUser.setFirstName(userData.get("firstName"));
            expectedUser.setLastName(userData.get("lastName"));
            expectedUser.setEmail(userData.get("email"));
            expectedUser.setPhone(userData.get("phone"));
            expectedUser.setStatus(Integer.parseInt(userData.get("status")));

            System.out.println("Este é o usuário esperado: " + usuariosData.toString());

            response = usuarioApi.createUserMap((Map<String, String>) expectedUser);
        }
    }

    @Entao("valido os dados do usuario criado")
    public void valido_os_dados_do_usuario_criado(List<Map<String, String>> usuariosData) {
        for (Map<String, String> userData : usuariosData) {
            assertThat("Nome de usuário deve ser válido", usuarioApi.getUsername(expectedUser), is(userData.get("username")));
            // Adicione outras validações de dados conforme necessário
        }
    }




}
