package pro.sky.libraries.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import pro.sky.libraries.models.Ingredient;
import pro.sky.libraries.models.Recipe;

@Service
public class ValidateService {
    public boolean isNotValid(Recipe recipe) {
        return StringUtils.isBlank(recipe.getTitle()) ||
                CollectionUtils.isEmpty(recipe.getIngredients()) ||
                CollectionUtils.isEmpty(recipe.getSteps()) ||
                recipe.getCookingTime() <= 0;
    }

    public boolean isNotValid(Ingredient ingredient) {
        return StringUtils.isBlank(ingredient.getTitle()) ||
                StringUtils.isBlank(ingredient.getMeasureUnit()) ||
                ingredient.getAmount() <= 0;
    }
}
