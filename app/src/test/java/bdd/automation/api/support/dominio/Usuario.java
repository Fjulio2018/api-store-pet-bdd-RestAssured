package bdd.automation.api.support.dominio;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {


    private String id   ;
    @Builder.Default
    private String username = "Nick";
    @Builder.Default
    private String password= "Nicc@3123";
    @Builder.Default
    private String firstName = "Nicolas";
    @Builder.Default
    private String lastName = "Wegan";
    @Builder.Default
    private String email= "nik.weg@malinator.com";
    @Builder.Default
    private String phone = "199923343464";
    private String userStatus ;


}
