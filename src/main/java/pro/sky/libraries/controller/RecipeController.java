package pro.sky.libraries.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pro.sky.libraries.models.Recipe;
import pro.sky.libraries.services.RecipeService;


import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable long recipeId) {
        return ResponseEntity.of(recipeService.getRecipeById(recipeId));
    }
    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
       return recipeService.addRecipe(recipe);
    }
    @PutMapping("/{recipeId}")
    public ResponseEntity<Recipe> editing(@PathVariable long recipeId,
                                              @RequestBody Recipe recipe){
        return ResponseEntity.of(recipeService.editing(recipeId,recipe));
    }
    @DeleteMapping("/{recipeId}")
    public ResponseEntity<Recipe> delete(@PathVariable long recipeId){
        return ResponseEntity.of(recipeService.delete(recipeId));
    }
    @GetMapping
    public Map<Long, Recipe> getAll(){
        return recipeService.getAll();
    }
}
