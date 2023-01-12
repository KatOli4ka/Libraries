package pro.sky.libraries.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.libraries.models.Ingredient;
import pro.sky.libraries.services.IngredientService;


import java.util.Map;



@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping("/{ingredientId}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable long ingredientId) {
       return ResponseEntity.of(ingredientService.getIngredientById(ingredientId));
    }
    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }
    @PutMapping("/{ingredientId}")
    public ResponseEntity<Ingredient> editing(@PathVariable long ingredientId,
                              @RequestBody Ingredient ingredient){
        return ResponseEntity.of(ingredientService.editing(ingredientId,ingredient));
    }
    @DeleteMapping("/{ingredientId}")
    public ResponseEntity<Ingredient> delete(@PathVariable long ingredientId){
        return ResponseEntity.of(ingredientService.delete(ingredientId));
    }

    @GetMapping
    public Map<Long, Ingredient> getAll(){
        return ingredientService.getAll();
    }


}