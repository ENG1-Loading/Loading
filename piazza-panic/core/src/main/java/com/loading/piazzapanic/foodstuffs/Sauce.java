package com.loading.piazzapanic.foodstuffs;

import com.badlogic.gdx.physics.box2d.Body;

public class Sauce extends Ingredient{
    /**
     * Create our instance of SauceBottle
     *
     * @param width the width of the sprite
     * @param height the height of the sprite
     * @param body the body date of the sprite
     * @param name the name to assign the sprite
     * @param path the sprite texture*/
    public Sauce(float width, float height, Body body, String path, String name) {
        super(width, height, body, path, name);
        this.cook_status = Cooking.NOCOOK;
        this.prep_status = Prepping.READYMADE;
    }





    @Override
    public void cook() {
        // TODO Auto-generated method stub

    }



    @Override
    public void update() {

    }

    @Override
    public void chop() {

    }
}
