package jp.ac.tuis.edu.taco.cloud.api.ingredients;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, String> {
    
}
