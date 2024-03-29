package com.loading.piazzapanic.foodstuffs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.loading.piazzapanic.Launcher;

public abstract class Ingredient extends com.loading.piazzapanic.Entity {

    Launcher _parent;

    Texture texture;
    Sprite sprite;
    String name;

    float x, y;
    
    /* Enums used for the state of the ingredient */
    public enum Cooking {
        RAW,
        COOKED,
        BURNT,
        NOCOOK,
    }

    enum Prepping {
        CHOPPED,
        READYMADE,
        PENDING,
    }

    Cooking cook_status;
    Prepping prep_status;

    /** Extends Entity, so requires the same parameters plus a few more
     * Every ingredient requires these additional parameters.
     * @param path A string that contains the relative path of the image file for the texture
     * @param name The ingredient name
     */

    public Ingredient(float width, float height, Body body, String path, String name) {
        super(width, height, body, width, height);
        this.texture = new Texture(path);
        this.sprite = new Sprite(texture);
        this.name = name;
    }
   
    @Override
    public void render(SpriteBatch batch) {
        sprite.setPosition(x, y);
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    /**
     * 
     * @param scale used to define the scaling of the sprite
     */
    public void setScale(float scale) {
        sprite.setScale(scale);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    /* The method used for chopping logic */
    public abstract void chop();

    public void setPosition(float _x, float _y) {
        x = _x;
        y = _y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public String getPrepStatus() {
        return prep_status.toString();
    }

    public Cooking getCookStatus() {
        return cook_status;
    }

    public abstract void cook();

    public String getName() {
        return name;
    }

}
