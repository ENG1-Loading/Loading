package com.loading.piazzapanic.foodstuffs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public class Lettuce extends Ingredient {

    public Lettuce(float width, float height, Body body, String path, String name) {
        super(width, height, body, path, name);
        this.cook_status = Cooking.NOCOOK;
        this.prep_status = Prepping.PENDING;
    }

    @Override
    public void chop() {
        prep_status = Prepping.CHOPPED;
        // Change sprite logic here
    }



    @Override
    public void update() {
        
    }

    @Override
    public void cook() {
        // TODO Auto-generated method stub
        
    }
    
}
