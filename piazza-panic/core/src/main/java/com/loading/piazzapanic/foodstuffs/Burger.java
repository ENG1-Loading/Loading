package com.loading.piazzapanic.foodstuffs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
                if (name == "chicken") {
                    texture = new Texture("assets/foodstuffs/chicken_cooked.png");
                } else {
                    texture = new Texture("assets/foodstuffs/beef_cooked.png");
                }
            case COOKED:
                cook_status = Cooking.BURNT;
                if (name == "chicken") {
                    texture = new Texture("assets/foodstuffs/chicken_burnt.png");
                } else {
                    texture = new Texture("assets/foodstuffs/beef_burnt.png");
                }
            default:
                break;
        }
        sprite = new Sprite(texture);
        update();
    }
    
}