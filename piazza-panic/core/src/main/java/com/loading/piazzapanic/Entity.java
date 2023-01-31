package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

/**
    * Abstract class used for all game entities
    *
    * @param x current x coordinate of the entity
    * @param y current y coordinate of the entity
    * @param width width of entity (for textures and bodies)
    * @param height height of entity (as above)
    * @param body Box2D Body that represents the entity
    * @param speed depreciated
*/

public abstract class Entity {
    
    protected float x, y, speed;
    protected float width, height;
    protected Body body;

    public Entity(float width, float height, Body body, float posx, float posy) {
        this.body = body;
        this.x = posx;
        this.y = posy;
        this.width = width;
        this.height = height;
        this.speed = 0;
    }

    /* Updates sprites, positions etc */
    public abstract void update();

    /** initial render method for the entity
     * @param batch the SpriteBatch used for rendering to a screen
     */
    public abstract void render(
            SpriteBatch batch);

    /* Returns the Box2D body */
    public Body getBody() {
        return body;
    }
}
