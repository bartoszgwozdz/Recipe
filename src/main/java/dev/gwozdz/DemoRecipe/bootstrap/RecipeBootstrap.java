package dev.gwozdz.DemoRecipe.bootstrap;

import dev.gwozdz.DemoRecipe.model.*;
import dev.gwozdz.DemoRecipe.repositories.CategoryRepository;
import dev.gwozdz.DemoRecipe.repositories.RecipeRepository;
import dev.gwozdz.DemoRecipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }

    private void loadData() {

        log.debug("RecipeBootstrap.java - loadData() - fetching UOM's");
        Optional<UnitOfMeasure> kiloGramOptional = unitOfMeasureRepository.findByDescription("kilogram");
        UnitOfMeasure kiloGram = kiloGramOptional.get();
        Optional<UnitOfMeasure> gramOptional = unitOfMeasureRepository.findByDescription("gram");
        UnitOfMeasure gram = gramOptional.get();
        Optional<UnitOfMeasure> sztukaOptional = unitOfMeasureRepository.findByDescription("sztuka");
        UnitOfMeasure sztuka = sztukaOptional.get();
        Optional<UnitOfMeasure> szklankaOptional = unitOfMeasureRepository.findByDescription("szklanka");
        UnitOfMeasure szklanka = szklankaOptional.get();
        Optional<UnitOfMeasure> lyzeczkaOptional = unitOfMeasureRepository.findByDescription("łyzeczka");
        UnitOfMeasure lyzeczka = lyzeczkaOptional.get();
        Optional<UnitOfMeasure> lyzkaOptional = unitOfMeasureRepository.findByDescription("łyzka");
        UnitOfMeasure lyzka = lyzkaOptional.get();
        Optional<UnitOfMeasure> mlOptional = unitOfMeasureRepository.findByDescription("ml");
        UnitOfMeasure ml = mlOptional.get();

        log.debug("RecipeBootstrap.java - loadData() - fetching Categories");

        Category polskaCategory = categoryRepository.findByDescription("Polska").get();
        Category wloskaCategory = categoryRepository.findByDescription("Wloska").get();

        Recipe zapiekankaRecipe = new Recipe();
        zapiekankaRecipe.setDescription("NAJLEPSZA ZAPIEKANKA ZIEMNIACZANA");
        zapiekankaRecipe.setCookTime(30);
        zapiekankaRecipe.setPrepTime(30);
        zapiekankaRecipe.setDifficulty(Difficulty.EASY);
        zapiekankaRecipe.setServings(3);
        zapiekankaRecipe.setSource("Ostra na słodko");
        zapiekankaRecipe.setUrl("http://ostra-na-slodko.pl/2020/03/17/najlepsza-zapiekanka-ziemniaczana/");
        zapiekankaRecipe.setDirections("Ziemniaki gotujemy na półtwardo, studzimy.\n" +
                "\n" +
                "Boczek i cebulę kroimy w kostkę, boczek podsmażamy ( tłuszczyk się wytopi ).\n" +
                "\n" +
                "Dodajemy cebulkę, smażymy kilka minut dodając odrobinę masła.\n" +
                "\n" +
                "Uważaj, żeby cebula się nie przypaliła, bo będzie gorzka!\n" +
                "\n" +
                "Naczynie do zapiekania natłuszczamy masłem, układamy warstwę pokrojonych w plastry ziemniaków.\n" +
                "\n" +
                "Przykrywamy częścią farszu i warstwą tartego sera.\n" +
                "\n" +
                "Warstwy układamy do wykończenia składników.\n" +
                "\n" +
                "Jajko roztrzepujemy, dodajemy Śmietankę oraz przyprawy.\n" +
                "\n" +
                "Zalewamy ułożone w foremce składniki ( wierzch możemy dodatkowo posypać świeżymi ziołami, np. pietruszką ).\n" +
                "\n" +
                "Zapiekamy ok. 35 minut w 180C.\n" +
                "\n" +
                "Smacznego!");

        zapiekankaRecipe.addIngredient(new Ingredient("ziemniaki", 1d, kiloGram));
        zapiekankaRecipe.addIngredient(new Ingredient("Surowy boczek", 400d, gram));
        zapiekankaRecipe.addIngredient(new Ingredient("Ser żółty CHEDDAR", 200d, gram));
        zapiekankaRecipe.addIngredient(new Ingredient("Smietana 30%", 0.25, szklanka));
        zapiekankaRecipe.addIngredient(new Ingredient("Jajko", 2d, sztuka));
        zapiekankaRecipe.addIngredient(new Ingredient("Masło", 0.25, sztuka));
        zapiekankaRecipe.addIngredient(new Ingredient("Oliwa czosnkowa", 0.1, szklanka));
        zapiekankaRecipe.addIngredient(new Ingredient("Sól, pieprz, gałka muszkatułowa", 0.25, lyzeczka));

        zapiekankaRecipe.addCategory(polskaCategory);
        recipeRepository.save(zapiekankaRecipe);
        log.debug("RecipeBootstrap.java - loadData() - created zapiekankaRecipe");


        Recipe poledwiczkiRecipe = new Recipe();
        poledwiczkiRecipe.setDescription("POLĘDWICZKI Z SUSZONYMI POMIDORAMI");
        poledwiczkiRecipe.setCookTime(35);
        poledwiczkiRecipe.setPrepTime(20);
        poledwiczkiRecipe.setDifficulty(Difficulty.EASY);
        poledwiczkiRecipe.setServings(4);
        poledwiczkiRecipe.setSource("Kwestia smaku");
        poledwiczkiRecipe.setUrl("https://www.kwestiasmaku.com/przepis/poledwiczki-z-suszonymi-pomidorami");
        poledwiczkiRecipe.setDirections("Polędwicę opłukać i osuszyć, odciąć białą błonę na boku. \n" +
                "Mięso pokroić ukośnie na 1 cm plasterki. Suszone pomidory pokroić na mniejsze kawałki, włożyć do małego garnka, wlać alkohol i zagotować.\n" +
                "Po minucie gotowania odstawić z ognia.\n" +
                "Rozgrzać dużą patelnię z pokrywą lub rondel z grubym dnem. Wlać 2 łyżki oleju z suszonych pomidorów.\n" +
                "Gdy olej będzie już gorący układać plasterki mięsa i smażyć przez ok. 2 - 3 minuty na złoty kolor. \n" +
                "W międzyczasie doprawić solą morską (niezbyt dużo, bo sos sojowy jest słony) oraz pieprzem. Przewrócić na drugą stronę i powtórzyć smażenie.\n" +
                "Wlać gorącą wodę i sos sojowy, dodać pieprz cayenne. Przykryć i zagotować. \n" +
                "Gotować pod przykryciem przez ok. 25 minut, do miękkości mięsa, w międzyczasie 1 - 2 razy mięso przewrócić.\n" +
                "Zdjąć pokrywę, dodać suszone pomidory wraz z płynem z gotowania i wymieszać. Dodać śmietankę, wymieszać potrząsając patelnią i gotować jeszcze przez ok. 5 minut. \n" +
                "Na koniec posypać przez sitko mąką ziemniaczaną, wymieszać i zagotować. Odstawić z ognia i posypać posiekaną natką pietruszki.");

        poledwiczkiRecipe.addIngredient(new Ingredient("Poledwica wieprzowa", 700d, gram, poledwiczkiRecipe));
        poledwiczkiRecipe.addIngredient(new Ingredient("Białe wytrawne wino", 0.5, szklanka, poledwiczkiRecipe));
        poledwiczkiRecipe.addIngredient(new Ingredient("Suszone pomidory", 12d, sztuka, poledwiczkiRecipe));
        poledwiczkiRecipe.addIngredient(new Ingredient("Woda", 1d, szklanka, poledwiczkiRecipe));
        poledwiczkiRecipe.addIngredient(new Ingredient("Sos sojowy", 5d, lyzka, poledwiczkiRecipe));
        poledwiczkiRecipe.addIngredient(new Ingredient("Pieprz cayene", 0.5, lyzeczka, poledwiczkiRecipe));
        poledwiczkiRecipe.addIngredient(new Ingredient("Smietana 30%", 150d, ml, poledwiczkiRecipe));
        poledwiczkiRecipe.addIngredient(new Ingredient("Skrobia ziemniaczana", 1d, lyzeczka, poledwiczkiRecipe));
        poledwiczkiRecipe.addIngredient(new Ingredient("Natka pietruszki", 1d, sztuka, poledwiczkiRecipe));

        poledwiczkiRecipe.addCategory(polskaCategory);
        poledwiczkiRecipe.addCategory(wloskaCategory);
        
        recipeRepository.save(poledwiczkiRecipe);
        log.debug("RecipeBootstrap.java - loadData() - created poledwiczkiRecipe");

    }
}
