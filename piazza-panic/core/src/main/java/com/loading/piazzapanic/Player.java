package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends Entity {

    Texture playerTexture;

    enum STATE {
        ACTIVE,
        WALKING,
        STATIC,
        CARRYING
    }

    public Player(float width, float height, Body body) {
        super(width, height, body);
        this.speed = 5f;
        //playerTexture = new Texture(Gdx.files.internal("assets/chef.png"));

    }

    @Override
    public void update() {
        x = this.body.getPosition().x * 32f;
        y = this.body.getPosition().y * 32f;
    }

    @Override
    public void render(SpriteBatch batch) {
        // TODO Auto-generated method stub
        
    }
    
}
