package com.HotelManagement.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Breakfast_Category")
public class BreakfastMenuCategory {
    public enum Category {
        BEVERAGES,
        PASTRIES,
        HOT_DISHES,
        COLD_DISHES,
        SIDES
    }
    private Category category;
}
/*
Beverages:

        Coffee
        Tea
        Orange Juice
        Apple Juice
        Milk
Pastries:

        Croissant
        Danish Pastry
        Bagel
        Muffin
Hot Dishes:

        Scrambled Eggs
        Omelette (with customizable ingredients)
        Pancakes
        Waffles
Cold Dishes:

        Yogurt
        Cereal
        Fruit Salad
        Cheese Platter
Sides:

        Bacon
        Sausages
        Hash Browns
        Toast (with various spreads)
*/
