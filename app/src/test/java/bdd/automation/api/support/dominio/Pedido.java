package bdd.automation.api.support.dominio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private int id = 007;
    private int petId = 2015;
    private int quantity = 11;
    private String shipDate = "2023-12-21T13:17:18.009Z";
    private String status = "placed";
    private boolean complete = true;









}
