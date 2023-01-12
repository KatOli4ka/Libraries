package pro.sky.newyummyrecipes.services;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import pro.sky.newyummyrecipes.models.Ingredient;
import pro.sky.newyummyrecipes.models.Recipe;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeService {
    private long recipeIdGenerator = 1;
    private  final Map<Long, Recipe> recipes = new HashMap<>();

    public Recipe addRecipe(Recipe recipe) {
        recipes.put(recipeIdGenerator++, recipe);
        return recipe;
    }

    public Optional<Recipe> getRecipeById(long recipeId) {
        return Optional.ofNullable(recipes.get(recipeId));
    }

    public Optional<Recipe> editing(long recipeId, Recipe recipe) {
        return Optional.ofNullable(recipes.replace(recipeId,recipe));
    }

    public Optional<Recipe> delete(long recipeId) {
        return Optional.ofNullable(recipes.remove(recipeId));
    }

    public Map<Long, Recipe> getAll() {
        return  new HashMap<>(recipes);
    }
}
