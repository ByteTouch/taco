package jp.ac.tuis.edu.taco.cloud.client.webclient;

import jp.ac.tuis.edu.taco.cloud.client.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
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
                .get()
                    .uri("http://ingredient-api/ingredients/{id}", id)
                .retrieve().bodyToMono(Ingredient.class);
    }
}
