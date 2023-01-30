package com.loading.piazzapanic.foodstuffs;

import com.badlogic.gdx.physics.box2d.Body;

public class Burger extends Ingredient {

    public Burger(float width, float height, Body body, String path, String name) {
        super(width, height, body, path, name);
        this.cook_status = Cooking.RAW;
        this.prep_status = Prepping.READYMADE;
    }

    @Override
    public void chop() {
        // TODO Auto-generated method stub
    }

    @Override
    public void cook() {
        switch(cook_status) {
            case RAW:
                cook_status = Cooking.COOKED;
            case COOKED:
                cook_status = Cooking.BURNT;
            default:
                break;
        }
        
    }
    
}