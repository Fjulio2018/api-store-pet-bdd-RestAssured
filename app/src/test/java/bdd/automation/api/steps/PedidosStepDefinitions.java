package bdd.automation.api.steps;

import bdd.automation.api.support.api.PedidoApi;
import bdd.automation.api.support.dominio.Pedido;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

public class PedidosStepDefinitions {

    private final Pedido pedido = new Pedido();
    private final PedidoApi pedidoApi = new PedidoApi();


    @Dado("que tenha pedidos feitos")
    public void que_tenha_pedidos_feitos() {

        System.out.println("Hello Word");

    }

    @Quando("procurar por id do pedidos")
    public void procurar_por_id_do_pedidos() {

        int idDefautClas = pedido.getId();


        pedidoApi.getOrderById(idDefautClas);


        System.out.println("Get de pedido por id: " + idDefautClas);

    }

    @Entao("o pedido com status {word} sera apresentado")
    public void o_pedido_com_status_placed_sera_apresentado(String status) {

        System.out.println("Response com todos os pedidos com status: " + status);

    }
}
