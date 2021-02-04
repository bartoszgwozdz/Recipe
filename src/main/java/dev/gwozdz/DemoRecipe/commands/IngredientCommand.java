package dev.gwozdz.DemoRecipe.commands;

import dev.gwozdz.DemoRecipe.model.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private String description;
    private Double quantity;
    private UnitOfMeasureCommand uom;
}
