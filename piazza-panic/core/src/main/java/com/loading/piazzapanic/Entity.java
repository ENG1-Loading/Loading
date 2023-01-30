package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

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

    public abstract void update();

    public abstract void render(
            SpriteBatch batch);

    public Body getBody() {
        return body;
    }
}
