package dev.gwozdz.DemoRecipe.services;

import dev.gwozdz.DemoRecipe.commands.RecipeCommand;
import dev.gwozdz.DemoRecipe.converters.RecipeCommandToRecipe;
import dev.gwozdz.DemoRecipe.converters.RecipeToRecipeCommand;
import dev.gwozdz.DemoRecipe.model.Recipe;
import dev.gwozdz.DemoRecipe.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    @InjectMocks
    private RecipeServiceImpl recipeService;
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Test
    void getRecipeByIdShouldReturnGivenRecipe(){
        //given
        Recipe givenRecipe = new Recipe();
        givenRecipe.setId(1l);
        Optional<Recipe> optionalGivenRecipe = Optional.of(givenRecipe);
        given(recipeRepository.findById(1l)).willReturn(optionalGivenRecipe);
        //when
        Recipe receivedRecipe = recipeService.getRecipeById(1l);
        //then
        assertThat(receivedRecipe, equalTo(givenRecipe));
    }

    @Test
    void getRecipeByIdShouldThrowWhenIdNotFound(){
        //given
        //when
        //then
        assertThrows(RuntimeException.class, () -> recipeService.getRecipeById(2));
    }

    @Test
    void getAllRecipesShouldInvokeFindAllFromRepository() {
        //given
        //when
        recipeService.getAllRecipes();
        //then
        then(recipeRepository).should().findAll();
    }

    @Test
    void getAllRecipesShouldReturnEmptySet(){
        //given
        //when
        Set<Recipe> retrievedRecipes = recipeService.getAllRecipes();
        //then
        assertThat(retrievedRecipes, emptyCollectionOf(Recipe.class));
    }

    @Test
    void getAllRecipesShouldReturnSetOfRecipes(){
        //given
        Set<Recipe> givenRecipes = new HashSet<>();
        givenRecipes.add(new Recipe());
        given(recipeRepository.findAll()).willReturn(givenRecipes);
        //when
        Set<Recipe> retrievedRecipes = recipeService.getAllRecipes();
        //then
        assertThat(retrievedRecipes, hasSize(1));
        assertThat(retrievedRecipes, contains(any(Recipe.class)));
    }

    @Test
    void saveRecipeCommandShouldHandleNull(){
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        //when
        recipeService.saveRecipeCommand(recipeCommand);
        //then
        verify(recipeCommandToRecipe, only()).convert(recipeCommand);
    }

    @Test
    void deleteRecipeByIdShouldInvokeRepositoryMethod(){
        //given
        Long id = Long.valueOf(2l);
        //when
        recipeService.deleteRecipeById(id);
        //then
        verify(recipeRepository, only()).deleteById(anyLong());

    }
}