package bdd.automation.api.steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

public class PedidosStepDefinitions {


    @Dado("que tenha pedidos feitos")
    public void que_tenha_pedidos_feitos() {
        System.out.println("Hello Word");

    }

    @Quando("Procurar por pedidos com status {word}")
    public void procurar_por_pedidos_com_status_pending(String status) {
        System.out.println("Get de pedido por status" + status);

    }

    @Entao("os pedidos com status {word} serao listados")
    public void os_pedidos_com_status_pending_serao_listados(String status) {

        System.out.println("Response com todos os pedidos com status" + status);

    }
}
