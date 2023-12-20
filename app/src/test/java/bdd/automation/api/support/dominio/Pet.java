package bdd.automation.api.support.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Pet {

    @Builder.Default
    private int id = 252;
    @Builder.Default
    private String name = "Arrit";
    @Builder.Default
    private Category category = new Category();
    @Builder.Default
    private String status = "Extinto";
    @Builder.Default
    private List<String> photoUrls = Arrays.asList("URL1", "URL2");


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    public static class Category {
        @Builder.Default
        private int id = 07;
        @Builder.Default
        private  String name = "Pitu";


    }







}


