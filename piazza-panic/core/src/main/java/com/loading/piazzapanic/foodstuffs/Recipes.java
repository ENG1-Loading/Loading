package com.loading.piazzapanic.foodstuffs;

import java.util.ArrayList;

public class Recipes {

    public final static ArrayList<String> CHICKEN_BURGER = new ArrayList<String>() {
        {
            add("Chicken");
            add("Bun");
            add("Lettuce");
            add("Tomato");
            add("Pickles"); 
            add("Mayo");
        }
    };
    public final static ArrayList<String> BEEF_BURGER = new ArrayList<String>() {
        { 
            add("Beef"); 
            add("Bun"); 
            add("Lettuce"); 
            add("Tomato"); 
            add("Pickles");
            add("Ketchup");
        }
    };
    public final static ArrayList<String> CHICKEN_SALAD = new ArrayList<String>() { 
        {
            add("Chicken");
            add("Lettuce");
            add("Tomato"); 
            add("Mayo"); 
        }
    };
    public final static ArrayList<String> PLAIN_SALAD = new ArrayList<String>() {
        {
            add("Lettuce");
            add("Tomato");
            add("Mayo");
        }
    };
    
}
