package com.loading.piazzapanic.foodstuffs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public class Tomato extends Ingredient {

    public Tomato(float width, float height, Body body, String path, String name) {
        super(width, height, body, path, name);
        this.cook_status = Cooking.NOCOOK;
        this.prep_status = Prepping.PENDING;
    }

    @Override
    public void chop() {
        prep_status = Prepping.CHOPPED;
        // change sprites
        // update
    }

    @Override
    public void cook() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    @Override
    public void update() {

    }


    
}
