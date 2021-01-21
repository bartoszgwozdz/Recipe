package dev.gwozdz.DemoRecipe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    public Ingredient(String description, Double quantity, UnitOfMeasure uom) {
        this.description = description;
        this.quantity = quantity;
        this.uom = uom;
    }

    public Ingredient(String description, Double quantity, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.quantity = quantity;
        this.uom = uom;
        this.recipe = recipe;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Double quantity;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;

}
