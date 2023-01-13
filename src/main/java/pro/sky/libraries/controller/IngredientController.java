package pro.sky.libraries.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.libraries.models.Ingredient;
import pro.sky.libraries.services.IngredientService;
import pro.sky.libraries.services.ValidateService;

import java.util.Map;
@Tag(name="IngredientController",description="API для игредиентов")
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    private final ValidateService validateService;

    public IngredientController(IngredientService ingredientService,
                                ValidateService validateService) {
        this.ingredientService = ingredientService;
        this.validateService=validateService;
    }
    @GetMapping("/{ingredientId}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable long ingredientId) {
       return ResponseEntity.of(ingredientService.getIngredientById(ingredientId));
    }
    @Operation(summary="addIngredient",description="Добавление ингредиентов")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Добавление прошло успешно!"),
            @ApiResponse(responseCode = "400",description = "Некорректные параметры рецепта!")
    })
    @PostMapping
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        if (validateService.isNotValid(ingredient)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ingredientService.addIngredient(ingredient));
    }
    @PutMapping("/{ingredientId}")
    public ResponseEntity<Ingredient> editing(@PathVariable long ingredientId,
                              @RequestBody Ingredient ingredient){
        if (validateService.isNotValid(ingredient)) {
            return ResponseEntity.badRequest().build();
        }
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