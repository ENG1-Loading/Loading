package com.loading.piazzapanic.foodstuffs;

import com.badlogic.gdx.physics.box2d.Body;

public class Bun extends Ingredient {

    public Bun(float width, float height, Body body, String path, String name) {
        super(width, height, body, path, name);
        this.cook_status = Cooking.NOCOOK;
        this.prep_status = Prepping.READYMADE;
    }

    @Override
    public void chop() {
        // TODO Auto-generated method stub    
    }

    @Override
    public void cook() {
        // TODO Auto-generated method stub
        
    }
    
}
