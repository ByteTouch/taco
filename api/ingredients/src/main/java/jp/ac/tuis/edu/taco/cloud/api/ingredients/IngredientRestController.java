/* This controller is not necessary now because of spring-boot-start-data-rest.

package jp.ac.tuis.edu.taco.cloud.api.ingredients;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientRestController {
    
    private IngredientRepository repo;

    @Autowired
    public IngredientRestController(IngredientRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/ingredients")
    public Iterable<Ingredient> allIngredients() {
        return repo.findAll();
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> ingredientById(@PathVariable("id") String id) {
        Optional<Ingredient> optIngredient = repo.findById(id);
        if (optIngredient.isPresent()) {
            return new ResponseEntity<>(optIngredient.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
*/