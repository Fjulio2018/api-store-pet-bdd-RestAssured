package bdd.automation.api.steps;

import bdd.automation.api.support.api.PetApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

import bdd.automation.api.support.dominio.Pet;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import io.restassured.response.Response; // Importe a classe Response correta aqui
import org.hamcrest.Matchers;

public class AnimalStepDefinitions {
    private PetApi petApi;
    List<Pet> existentePets;
    Response respo;

    public AnimalStepDefinitions() {
        petApi = new PetApi();
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
        for (Pet pet : existentePets) {
            assertThat(pet.getStatus(), Matchers.equalTo(status));
            System.out.println("Print dos Status encontrados: " + pet.getStatus());
        }

        respo.then().assertThat().body("", hasSize(qnt));


        int statusCode = respo.getStatusCode();
        assertThat(statusCode, Matchers.equalTo(200));
    }



}
