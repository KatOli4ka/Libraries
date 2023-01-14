package pro.sky.libraries.services;

import org.springframework.stereotype.Service;
import pro.sky.libraries.models.Ingredient;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class IngredientService {
    private long ingredientIdGenerator = 1;
    private final Map<Long, Ingredient> ingredients = new HashMap<>();

    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(ingredientIdGenerator++, ingredient);
        return ingredient;
    }

    public Optional<Ingredient> getIngredientById(long ingredientId) {
        return Optional.ofNullable(ingredients.get(ingredientId));
    }

    public Optional<Ingredient> editing(long ingredientId, Ingredient ingredient) {
        return Optional.ofNullable(ingredients.replace(ingredientId, ingredient));
    }

    public Optional<Ingredient> delete(long ingredientId) {
        return Optional.ofNullable(ingredients.remove(ingredientId));
    }

    public Map<Long, Ingredient> getAll() {
        return new HashMap<>(ingredients);
    }
}
