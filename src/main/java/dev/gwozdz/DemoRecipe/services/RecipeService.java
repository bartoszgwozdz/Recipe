package dev.gwozdz.DemoRecipe.services;

import dev.gwozdz.DemoRecipe.commands.RecipeCommand;
import dev.gwozdz.DemoRecipe.model.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getAllRecipes();

    Recipe getRecipeById(long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    RecipeCommand getRecipeCommandById(long id);
}
