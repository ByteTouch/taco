package jp.ac.tuis.edu.taco.cloud.client.feign;

import jp.ac.tuis.edu.taco.cloud.client.Ingredient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("ingredient-api")
public interface IngredientServiceFeignClient {
    @GetMapping("/ingredients/{id}")
    Ingredient getIngredient(@PathVariable("id") String id);
}
