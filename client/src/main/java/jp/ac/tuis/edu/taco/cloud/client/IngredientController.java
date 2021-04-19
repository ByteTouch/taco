package jp.ac.tuis.edu.taco.cloud.client;

import jp.ac.tuis.edu.taco.cloud.client.webclient.IngredientServiceClient;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    private IngredientServiceClient client;

    @Autowired
    public IngredientController(
            @Qualifier("reactiveClient") IngredientServiceClient client)
    {
        this.client = client;
    }

    @GetMapping
    public String ingredientListPage(Model model) {
        model.addAttribute("ingredients", client.getAllIngredients());
        return "ingredientList";
    }

    @GetMapping("/{id}")
    public String ingredientDetailPage(@PathVariable("id") String id, Model model) {
        Mono<Ingredient> ingredient = client.getIngredientById(id);
        if (ingredient == null) {
            return "ingredientNotFound";
        }
        model.addAttribute("ingredient", ingredient);
        return "ingredientDetail";
    }
}
