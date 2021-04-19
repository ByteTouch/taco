package jp.ac.tuis.edu.taco.cloud.client;

import jp.ac.tuis.edu.taco.cloud.client.webclient.IngredientServiceClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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
    @HystrixCommand(fallbackMethod = "IngredientNotFoundPage")
    public String ingredientDetailPage(@PathVariable("id") String id, Model model) {
        model.addAttribute("ingredient", client.getIngredientById(id));
        return "ingredientDetail";
    }

    public String defaultIngredientDetailPage() {
        return "ingredientNotFound";
    }
}
