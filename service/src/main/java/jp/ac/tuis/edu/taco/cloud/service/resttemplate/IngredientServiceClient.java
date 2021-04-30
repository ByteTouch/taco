package jp.ac.tuis.edu.taco.cloud.service.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

import jp.ac.tuis.edu.taco.cloud.service.Ingredient;

//@Service("restTemplateClient")
public class IngredientServiceClient {

    private RestTemplate rest;

    @Autowired
    public IngredientServiceClient(@LoadBalanced RestTemplate rest) {
        this.rest = rest;
    }

    public Ingredient getIngredientById(String id) {
        return rest.getForObject(
                "http://ingredient-api/ingredients/{id}",
                Ingredient.class, id
        );
    }
}
