package jp.ac.tuis.edu.taco.cloud.service;

import jp.ac.tuis.edu.taco.cloud.service.webclient.IngredientServiceClient;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.*;

@RestController
@RequestMapping(path = "/", produces = "application/hal+json")
public class ServiceController {  
    
    private IngredientServiceClient ingredientClient;

    @Autowired
    public ServiceController(IngredientServiceClient ingredientClient) {
        this.ingredientClient = ingredientClient;
    }

    @GetMapping("/ingredients/{id}")
    public Mono<EntityModel<Ingredient>> getIngredientById(@PathVariable("id") String id) {
        return ingredientClient.getIngredientById(id)
            .flatMap(ingredient -> {
                EntityModel<Ingredient> model = EntityModel.of(ingredient);
                Mono<Link> link = linkTo(methodOn(ServiceController.class).getIngredientById(id)).withSelfRel().toMono();
                return link.map(lk -> model.add(lk));
            });
    }
}
