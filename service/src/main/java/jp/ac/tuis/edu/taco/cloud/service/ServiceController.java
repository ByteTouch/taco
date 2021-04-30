package jp.ac.tuis.edu.taco.cloud.service;

import jp.ac.tuis.edu.taco.cloud.service.webclient.IngredientServiceClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {  
    
    private IngredientServiceClient ingredientClient;

    @Autowired
    public ServiceController(IngredientServiceClient ingredientClient) {
        this.ingredientClient = ingredientClient;
    }

    @GetMapping("/ingredients/{id}")
    public EntityModel<Ingredient> getIngredientById(@PathVariable("id") String id) {
        return ingredientClient.getIngredientById(id).block();
    }
}
