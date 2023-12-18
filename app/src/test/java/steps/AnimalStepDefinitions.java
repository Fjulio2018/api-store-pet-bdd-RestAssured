package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

import support.dominio.Pet;

public class AnimalStepDefinitions {

    @Dado("que tenha animais criados")
    public void que_tenha_animais_criados() throws JsonProcessingException {

        Pet pet = Pet.builder().build();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pet);
        System.out.println("Animais Existentes: " + json);

    }

    @Quando("a requisicao e feita")
    public void a_requisicao_e_feita() {
        System.out.println("Animais Requisitados");
    }

    @Entao("os animais sao listados")
    public void os_animais_sao_listados() {
        System.out.println("Animais Listados");
    }


}
