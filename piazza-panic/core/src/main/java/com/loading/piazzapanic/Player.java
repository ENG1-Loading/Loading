package com.loading.piazzapanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends Entity {

    Texture playerTexture;
    Sprite playerSprite;

    boolean active;

    /* maybe switch to using enums
    enum STATE {
        ACTIVE,
        WALKING,
        STATIC,
        CARRYING
    }
    */

    public Player(float width, float height, Body body, String path) {
        super(width, height, body);
        this.speed = 5f;
        this.playerTexture = new Texture(path);
        this.playerSprite = new Sprite(playerTexture);
        this.body.setUserData(playerSprite);
    }

    @Override
    public void update() {
        x = body.getPosition().x * 32f;
        y = body.getPosition().y * 32f;

        doUserInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        playerSprite.setX(x);
        playerSprite.setY(y); 
        playerSprite.draw(batch);
    }

    private void doUserInput() {
        velX = 0;
        velY = 0;

        if (active) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                velX -= 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                velX += 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                velY -= 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                velY -= 1;
            }
        }

        body.setLinearVelocity(velX * speed, velY * speed);
    }

    public void setActivePlayer(boolean state) {
        active = state;
    }

    public boolean getActivePlayer() {
        return active;
    }
    
}
