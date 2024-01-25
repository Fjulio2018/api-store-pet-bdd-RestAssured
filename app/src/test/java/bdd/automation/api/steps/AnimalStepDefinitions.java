package bdd.automation.api.steps;

import bdd.automation.api.support.api.AnimalApi;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

import bdd.automation.api.support.dominio.Animal;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import io.restassured.response.Response;
import org.hamcrest.Matchers;

public class AnimalStepDefinitions {
    private AnimalApi petApi;
    List<Animal> existentePets;
    Response respo;

    public AnimalStepDefinitions() {
        petApi = new AnimalApi();
    }

    @Dado("que tenha animais criados")
    public void que_tenha_animais_criados(){
//    "Vamos deixar o 'DADO' apenas para futoras criacoes "
    }

    @Quando("a pesquiso animais com status {word}")
    public void a_pesquiso_animais_com_status_available(String status) {
        existentePets = petApi.getPetByList(status);

        respo = petApi.getPetByResponse(status);
        System.out.println("Print da quantidade de Pets "+status+": " + respo.jsonPath().getList("$").size());


    }

    @Entao("os {int} animais com status {word} sao listados")
    public void os_animais_com_status_available_sao_listados(int qnt, String status) {
        for (Animal animal : existentePets) {
            assertThat(animal.getStatus(), Matchers.equalTo(status));
            System.out.println("Print dos Status encontrados: " + animal.getStatus());
        }

        respo.then().assertThat().body("", hasSize(qnt));


        int statusCode = respo.getStatusCode();
        assertThat(statusCode, Matchers.equalTo(200));
    }


    @Dado("que tenha os dados dos animais")
    public void que_tenha_os_dados_dos_animais(DataTable dataTable) {
        List<Map<String, String>> animaisData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> animalData : animaisData) {
            System.out.println("ID do animal: " + animalData.get("id"));

        }
    }


    @Quando("performar a criacao")
    public void performar_a_criacao() {
        System.out.println("Performar a criacao");

    }

    @Entao("validomos a criacao")
    public void validomos_a_criacao() {
        System.out.println("validar a criacao");

    }

}
