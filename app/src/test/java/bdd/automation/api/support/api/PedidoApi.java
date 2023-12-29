package bdd.automation.api.support.api;

import static io.restassured.RestAssured.given;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class PedidoApi {

    private static final String ADD_ORDER_ENDPOINT = "/store/order";
    private static final String FIND_ORDER_BY_ID_ENDPOINT = "/store/order/id={id}";


    public String getOrderById(int id) {

        String strId = String.valueOf(id);

         String response =

                given()
                       .pathParam("id", strId)
                .when()
                        .get(FIND_ORDER_BY_ID_ENDPOINT)
                .then()
                        .extract().body().jsonPath().toString();

        return response;











    }


}
