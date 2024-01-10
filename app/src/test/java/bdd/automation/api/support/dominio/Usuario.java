package bdd.automation.api.support.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Builder.Default
    private int id = 1 ;
    @Builder.Default
    private String username = "Nick";
    @Builder.Default
    private String firstName = "Nicolas";
    @Builder.Default
    private String lastName = "Wegan";
    @Builder.Default
    private String email= "nik.weg@malinator.com";
    @Builder.Default
    private String password= "Nicc@3123";
    @Builder.Default
    private String phone = "199923343464";
    @Builder.Default
    private int userStatus = 1;

}
