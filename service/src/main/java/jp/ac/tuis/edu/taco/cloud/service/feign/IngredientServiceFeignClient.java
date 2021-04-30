package jp.ac.tuis.edu.taco.cloud.service.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.ac.tuis.edu.taco.cloud.service.Ingredient;

//@FeignClient("ingredient-api")
public interface IngredientServiceFeignClient {
    @GetMapping("/ingredients/{id}")
    Ingredient getIngredient(@PathVariable("id") String id);
}
