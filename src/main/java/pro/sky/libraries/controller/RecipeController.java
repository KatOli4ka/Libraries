package pro.sky.libraries.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pro.sky.libraries.models.Recipe;
import pro.sky.libraries.services.RecipeService;
import pro.sky.libraries.services.ValidateService;


import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;
    private final ValidateService validateService;

    public RecipeController(RecipeService recipeService,
                            ValidateService validateService) {
        this.recipeService = recipeService;
        this.validateService=validateService;
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable long recipeId) {
        return ResponseEntity.of(recipeService.getRecipeById(recipeId));
    }
    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        if (validateService.isNotValid(recipe)) {
            return ResponseEntity.badRequest().build();
        }
       return ResponseEntity.ok(recipeService.addRecipe(recipe));
    }
    @PutMapping("/{recipeId}")
    public ResponseEntity<Recipe> editing(@PathVariable long recipeId,
                                              @RequestBody Recipe recipe){
        if (validateService.isNotValid(recipe)) {
            return ResponseEntity.badRequest().build();
        }
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
