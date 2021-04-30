package jp.ac.tuis.edu.taco.cloud.service.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import jp.ac.tuis.edu.taco.cloud.service.Ingredient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("reactiveClient")
public class IngredientServiceClient {

    private WebClient.Builder wcBuilder;

    @Autowired
    public IngredientServiceClient(@LoadBalanced WebClient.Builder wcBuilder) {
        this.wcBuilder = wcBuilder;
    }

    public Mono<Ingredient> getIngredientById(String id) {
        return wcBuilder.build()
                .get().uri("http://ingredient-api/ingredients/{id}", id)
                .retrieve().bodyToMono(Ingredient.class);
    }

    public Flux<Ingredient> getAllIngredients() {
        return wcBuilder.build()
                .get().uri("http://ingredient-api/ingredients")
                .retrieve().bodyToFlux(Ingredient.class);
    }

    /*
    @Nullable
    public Mono<Ingredient> ingredientNotFound(String id) {
        return null;
    }

    public Flux<Ingredient> defaultIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
        ingredients.add(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
        ingredients.add(new Ingredient("CHED", "Shredded Cheddar", Ingredient.Type.CHEESE));
        return Flux.fromIterable(ingredients);
    }
    */
}
